package problems;

import lib.BigIntegers;
import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;

@Solved
public class p056 extends Problem {

    public static void main(String[] args) {
        Problem p = new p056();
        p.run();
        System.out.println(p.answer());
    }

    /**
     * tried using double but seemed to loose precision
     */
    public void run() {
        int max = 0;
        for(int b = 99; b >= 0; b--) {
            for(int a = 99; a >= 0; a--) {
                int sum = 0;
                BigInteger v = BigIntegers.pow(a, b);
                while(v.compareTo(BigInteger.ZERO) != 0) {
                    sum += v.mod(BigInteger.TEN).intValue();
                    v = v.divide(BigInteger.TEN);
                }
                if(sum > max) {
                    max = sum;
                }
            }
        }
        this.answer = max;
    }

}
