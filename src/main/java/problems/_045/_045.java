package problems._045;

import main.Problem;
import main.annotations.Solved;

@Solved
public class _045 extends Problem {

    public static void main(String[] args) {
        Problem p = new _045();
        p.run();
        System.out.println(p.answer());
    }

    /**
     *
     * patterns:
     * Tn=n(n+1)/2
     *  1, 3, 6, 10, 15, ...
     *  +2, +3, +4, ...
     *  d/dn = (2n + 1)/2
     *  d2/dn = 1
     *
     * Pn=n(3n−1)/2
     *  1, 5, 12, 22, 35, ...
     *  +4, +7, +10, +13, ...
     *  d/dn = (6n - 1)/2
     *  d2/dn = 3
     *
     * Hn=n(2n−1)
     *  1, 6, 15, 28, 45, ...
     *  +5, +9, +13
     *  d/dn = (4n - 1)
     *  d2/dn = 4
     */
    public void run() {
        long d2dt = 1;
        long d2dp = 3;
        long d2dh = 4;

        // could start out using values for t(n),p(n),h(n), t'(n), p'(n),h'(n)
        // such that they yield 40755 for start state but the answer is so large
        // that it doesn't really shave that much time off
        long d1dt = 1;
        long d1dp = 1;
        long d1dh = 1;

        long tphn = 0;
        long tn = tphn;
        long pn = tphn;
        long hn = tphn;

        for (long n = 40756;; n++) {
            while (tn < n) {
                tn += d1dt;
                d1dt += d2dt;
            }
            while (pn < n) {
                pn += d1dp;
                d1dp += d2dp;
            }
            while (hn < n) {
                hn += d1dh;
                d1dh += d2dh;
            }

            if (tn == pn && pn == hn && hn == n) {
                this.answer = n;
                break;
            }
        }

    }

}
