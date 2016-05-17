package problems;

import lib.BigIntegers;
import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;

@Solved
public class p048 extends Problem {

    public static void main(String[] args) {
        Problem p = new p048();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        BigInteger sum = BigInteger.ZERO;

        for(int n = 1; n <= 1000; n++) {
            sum = sum.add(BigIntegers.pow(n, n));
        }
        String nStr = sum.toString();
        this.answer = nStr.substring(nStr.length() - 10);
    }

}
