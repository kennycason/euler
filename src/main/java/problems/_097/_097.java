package problems._097;

import main.Problem;
import main.annotations.Solved;

@Solved
public class _097 extends Problem {

    public static void main(String[] args) {
        Problem p = new _097();
        p.run();
        System.out.println(p.answer());
    }

    /**
     * tried using double but seemed to loose precision
     */
    public void run() {
        /* 28433 × 2^7830457 + 1.
           2 ^ 7830457 <-----
           since we are only looking at the LAST 10 digits,
           lets just ignore any larger digits,
         */
        long n = 2;
        for(int i = 1; i < 7830457; i++) {
            n = (n * 2) % 10000000000L;
        }
        n = n * 28433 + 1;
        n = n % 10000000000L;
        this.answer = n;
    }

}
