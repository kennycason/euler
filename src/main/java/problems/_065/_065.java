package problems._065;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;

@Solved
public class _065 extends Problem {

    public static void main(String[] args) {
        Problem p = new _065();
        p.run();
        System.out.println(p.answer());
    }

    /*
    The infinite continued fraction can be written, √2 = [1;(2)], (2) indicates that 2 repeats ad infinitum. In a similar way, √23 = [4;(1,3,1,8)].

    e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
    The first ten terms in the sequence of convergents for e are:
    2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
    The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
    Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.

    2 + 1
       ---
       1 + 1
          ---
          2 + 1
             ---
             1 + 1
                ---
                1 + 1
                   ---
                   4 + 1
                      ---
                      1 ....
     */
    public void run() {
        BigInteger n = BigInteger.valueOf(2);
        BigInteger d = BigInteger.ONE;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger three = BigInteger.valueOf(3);
        for(int i = 2; i <= 100; i++) {
            BigInteger bigI = BigInteger.valueOf(i);
            BigInteger oldD = d;
            BigInteger multiplier = bigI.mod(three).equals(BigInteger.ZERO) ? two.multiply(bigI).divide(three) : BigInteger.ONE;
                   // (i % 3 == 0) ? (2 * i / 3) : 1;
            d = n;
            n = multiplier.multiply(d).add(oldD);
            //System.out.println("> " + n);
        }
        this.answer = Numbers.sumDigits(n.toString());
    }

}
