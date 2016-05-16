package problems._057;

import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;
import java.util.Arrays;

@Solved
public class _057 extends Problem {

    public static void main(String[] args) {
        Problem p = new _057();
        p.run();
        System.out.println(p.answer());
    }

    /**
     *     1 + 1/2 = 3/2 = 1.5
     *    1 + 1/(2 + 1/2) = 7/5 = 1.4
     *  1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
     *  1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
     *
     *  pattern time:
     *  1 + 1/2                 = 3/2
     *  1 + 1/(2 + 1/2)         = 1 + 1/(5/2) = 1 + 2/5 = 7 / 5
     *  1 + 1/(2 + 1/(2 + 1/2)) = 1 + 1/(2 + 1/(5/2)) = 1 + 1/(2 + 2/5)) = 1 + 1/(12/5) = 1 + 5/12 = 17/12
     *  1 + 1/(2 + 1/(2 + 1/(2 + 1/2)))
     *                          = 1 + 1/(2 + 1/(2 + 1/(5/2))) = 1 + 1/(2 + 1/(2 + 2/5)))
     *                          = 1 + 1/(2 + 1/(12/5)) = 1 + 1/(2 + 5/12) = 1 + 1/(29/12) = 1 + 12/29 = 41/29
     */
    public void run() {
        // solve();
        faster();
    }

    /**
     * denominator is the sum of the previous numerator and the previous denominator.
     * numerator is the sum of the denominator and the previous denominator.
     *
     * 3/2, (2 + 5)/5, (5 + 12)/12, ...
     */
    private void faster() {
        BigInteger[] denoms = new BigInteger[1000];
        BigInteger[] nums = new BigInteger[1000];

        nums[0] = BigInteger.valueOf(3);
        denoms[0] = BigInteger.valueOf(2);

        for (int i = 1; i < 1000; i++) {
            denoms[i] = nums[i - 1].add(denoms[i - 1]);
            nums[i] = denoms[i].add(denoms[i - 1]);
        }

        int count = 0;
        for (int i = 1; i < 1000; i++) {
            if (nums[i].toString().length() > denoms[i].toString().length()) {
                count++;
            }
        }
        this.answer = count;
    }

    @SuppressWarnings("unused")
    private void solve() {
        int count = 0;
        for(int i = 0; i < 1000; i++) {
            BigInteger[] fract = sqrt2Fract(i);
            BigInteger num = fract[1].add(fract[0]);
            BigInteger denom = fract[1];
             if(num.toString().length() > denom.toString().length()) {
                 count++;
             }
             // System.out.println(num + "/" + denom);
        }
        this.answer = count;
    }

    @SuppressWarnings("unused")
    private void test() {
        for(int i = 0; i < 4; i++) {
             System.out.println(" = 1" + printSqrt2(i));
             System.out.println(1.0 + sqrt2(i));
             System.out.println(Arrays.toString(sqrt2Fract(i)));
        }
    }

    // [num, denom]
    private BigInteger[] sqrt2Fract(int iter) {
        if(iter <= 0) {
            return new BigInteger[] {BigInteger.valueOf(1), BigInteger.valueOf(2)};
        }
        BigInteger[] fract = sqrt2Fract(--iter);
        // goal: 1 / (2 + fract)
        // step 1: 2 + fract
        BigInteger num = fract[1].multiply(BigInteger.valueOf(2)).add(fract[0]);
        BigInteger denom = fract[1];
        // step 2: 1 / (num/denom)
        return new BigInteger[] {denom, num};
    }

    private double sqrt2(int iter) {
        if(iter <= 0) {
            return 0.5;
        }
        double v = sqrt2(--iter);
        v = 1 / (2 + v);
        return v;
    }

    private String printSqrt2(int iter) {
        if(iter <= 0) {
            return " + 1/2";
        }
        String v = " + 1/(2 ";
        v += printSqrt2(--iter);
        v += ")";
        return v;
    }

}
