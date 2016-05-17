package problems;

import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;

@Solved
public class p120 extends Problem {

    public static void main(String[] args) {
        Problem p = new p120();
        p.run();
        System.out.println(p.answer());
    }

    /**
     Let r be the remainder when (a−1)^n + (a+1)^n is divided by a^2.
     For example, if a = 7 and n = 3, then r = 42: 6^3 + 8^3 = 728 ≡ 42 mod 49. And as n varies, so too will r, but for a = 7 it turns out that rmax = 42.
     For 3 ≤ a ≤ 1000, find ∑ r max.
     */
    public void run() {
        long rMaxes = 0;
        for(int r = 3; r <= 1000; r++) {
            rMaxes += rMax(r);
        }
        this.answer = rMaxes;
    }

    public long rMax(int a) {
        return 2 * a * ((a - 1) / 2); // add in a - 1 instead of a because it must be LESS than a^2
    }

    // semi-brute force
    public void run2() {
        long rMaxes = 0;
        for(int r = 3; r <= 1000; r++) {
            rMaxes += rMax2(r);
        }
        this.answer = rMaxes;
    }

    // compute power inline
    public long rMax2(int a) {
        BigInteger a2 = BigInteger.valueOf(a * a);
        long rMax = 0;
        int n = 1;
        BigInteger aMinus1 = BigInteger.valueOf(a - 1);
        BigInteger aPlus1 = BigInteger.valueOf(a + 1);
        BigInteger powerMinus = BigInteger.ONE;
        BigInteger powerPlus = BigInteger.ONE;
        for(;;) {
            powerMinus = powerMinus.multiply(aMinus1);
            powerPlus = powerPlus.multiply(aPlus1);
            long r = (powerMinus.add(powerPlus)).mod(a2).longValue();
            if(r >= rMax) {
                rMax = r;
            }
            n++;
            if(n == 1500) { // manually backed down from an arbitrary high number
                System.out.println(a + " -> " + rMax);
                return rMax;
            }
        }
    }

}
