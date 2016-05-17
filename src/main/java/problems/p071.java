package problems;

import main.Problem;
import main.annotations.Solved;

@Solved
public class p071 extends Problem {

    public static void main(String[] args) {
        Problem p = new p071();
        p.run();
        System.out.println(p.answer());
    }

    /**
     * want to find a n/d such that it's less thats 3/7
     * n/d < 3/7
     * 7n < 3d
     *
     * generically
     * n/d < a/b
     *
     * n*b < a*d
     * largest n allowed for solution to work is
     * n < a*d / b
     * probably should make equality, by subtracting 1 from left side as numerators/denominators will be integers
     * n*b <= a*d - 1
     * n <= (a*d - 1) / b
     *
     * iterate over n/d updating best solution (nf/df)
     * such that nf/df < n/d
     * nf*d < n*df
     */
    public void run() {
        long a = 3;    // upper threshold
        long b = 7;
        long nf = 0;    // best
        long df = 1;

        for(int i = 3; i < 1000000; i++) {
            long n = (a * i - 1) / b;
            if(n * df > nf * i) {
                df = i;
                nf = n;
            }
        }
        // System.out.println(nf + "/" + df);
        this.answer = nf;
    }


}
