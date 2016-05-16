package problems._053;

import lib.Probability;
import main.Problem;
import main.annotations.Solved;

import java.math.BigInteger;

@Solved
public class _053 extends Problem {

    public static void main(String[] args) {
        Problem p = new _053();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int total = 0;
        for(int n = 1; n <= 100; n++) {
            for(int k = 0; k <= n; k++) {
                if(Probability.bigCombination(n, k).compareTo(BigInteger.valueOf(1000000)) == 1) {
                    total++;
                }
            }
        }
        this.answer = total;
    }

}
