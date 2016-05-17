package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;

@Solved
public class p104 extends Problem {

    public static void main(String[] args) {
        Problem p = new p104();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        final BigInteger last9DigitsMask = BigInteger.valueOf(1000000000);
        BigInteger i = BigInteger.ZERO;
        BigInteger j = BigInteger.ONE;

        for(int n = 2; n < Integer.MAX_VALUE; n++) {
            // if( n % 10000 == 0) { System.out.println("Computing f(" + n + ")"); }
            BigInteger sum = i.add(j);
            i = j;
            j = sum;

            final int last9Digits = j.mod(last9DigitsMask).intValue();
            if(Numbers.is1To9PanDigit(last9Digits)) {

                final String numAsString = sum.toString();
                final int first9Digits = Integer.parseInt(numAsString.substring(0, 9));
                if(Numbers.is1To9PanDigit(first9Digits)) {
                    this.answer = n;
                    // System.out.println("fib(" + n + ") = " + j);
                    return;
                }
            }

        }

    }

}
