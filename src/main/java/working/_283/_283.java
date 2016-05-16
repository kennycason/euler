package working._283;

import lib.Numbers;
import main.Problem;


public class _283 extends Problem {

    public static void main(String[] args) {
        Problem p = new _283();
        p.run();
        System.out.println(p.answer());
    }

    /**
     * patterns
     * (5, 12, 13), p = 30, area = 30.0, ratio = 1.0, gcd = 1
     * (10, 24, 26), p = 60, area = 120.0, ratio = 2.0, gcd = 2
     * (20, 48, 52), p = 120, area = 480.0, ratio = 4.0, gcd = 4
     * 2a  2b  2c
     *
     * (3, 4, 5), p = 12, area = 6.0, ratio = 0.5, gcd = 1  (not included),
     * special case 6,8,10 is only triangle starting from gcd > 1?
     *         yes, extrapolate(14, 130, 136), gcd =2, extrapolate(7, 65, 68) gcd = 1, but ratio = 1.5..
     *
     * (6, 8, 10), p = 24, area = 24.0, ratio = 1.0, gcd = 2
     * (12, 16, 20), p = 48, area = 96.0, ratio = 2.0, gcd = 4
     * (18, 24, 30), p = 72, area = 216.0, ratio = 3.0, gcd = 6
     * (a + 6) (b + 8) (c + 10)
     *
     * (10, 35, 39), p = 84, area = 168.0, ratio = 2.0, gcd = 1
     * (20, 70, 78), p = 168, area = 672.0, ratio = 4.0, gcd = 2
     * (40, 140, 156), p = 336, area = 2688.0, ratio = 8.0, gcd = 4
     * (60, 210, 234), p = 504, area = 6048.0, ratio = 12.0, gcd = 6
     * (a + 20) (b + 70) (c + 78)
     *
     * (13, 14, 15), p = 42, area = 84.0, ratio = 2.0, gcd = 1
     * (26, 28, 30), p = 84, area = 336.0, ratio = 4.0, gcd = 2
     * (39, 42, 45), p = 126, area = 756.0, ratio = 6.0, gcd = 3
     * (52, 56, 60), p = 168, area = 1344.0, ratio = 8.0, gcd = 4
     *
     */
    public _283() {
        solved(false);
    }

    public void run() {
        //System.out.println(extrapolate(7, 65, 68)); // ratio 1.5, gcd = 1
        //System.out.println(extrapolate(14, 130, 136)); // ratio = 2, gcd = 2...

        long sum = 0;
        for(int a = 1; a < 200; a++) { // offset b, and c starts to eliminate doubles;
            for(int b = a; b < 200; b++) {
                for(int c = b; c < 200; c++) {
                    int p = a + b + c;

                    double area = area(a, b, c);
                    if(area == -1) {
                        continue;
                    }
                    double ratio = area / p;
                    if(area % p == 0 && ratio <= 1000) {
                        if(Numbers.gcd(a, b, c) != 1) { // we only want ratio = 1, so we can begin extrapolating, not true for all a, b, c...
                            break;
                        }
                        // begin extrapolating;
                        sum += extrapolate(a, b, c);
                    }
                }
            }
        }
        sum += extrapolate(6, 8, 10);
        this.answer = sum;
    }

    /**
     *  triangle ABC
     *        A
     *        |
     *    c   |h      b
     *        |
     * B--x---P-----(a-x)---C
     *  \________a___________/
     *  
     *  x^2 + h^2 = c^2
     *  h^2 + (a-x)^2 = b^2
     *  cos(C) = (a-x)/b
     *  x = a - b * cos(C);
     *  
     *  h^2 + a^2 - 2ax + x^2 = b^2
     *  c^2 = a^2 + b^2 - 2ab * cos(C)
     *  cos(C) = (c^2 - a^2 - b^2) / -2ab
     *  c = sqrt(a^2 + b^2 - 2ab * cos(C))
     *  use this to extrapolate c based on extending a & b
     */
    private long extrapolate(int a, int b, int c) {
        double cosC = (c * c - a * a - b * b) / (-2.0 * a * b);
        System.out.println("start: " + a + " " + b + " " + c + " cos(C) = " + Math.acos(cosC) * 180 / Math.PI);
        int a0 = a;
        int b0 = b;
        long sum = 0;
        double ratio = 0;
        for(;;) {
            double d = a * a + b * b - (2.0 * a * b * cosC);
            if(d < 0) {
                return sum;
            }
            c = (int) Math.sqrt(d);
            double area = area(a, b, c);
            int p = a + b + c;
            ratio = area / p;
            if(ratio > 1000) {
                return sum;
            }

            // System.out.println("(" + a + ", " + b + ", " + c + "), p = " + p + ", area = " + area + ", ratio = " + (area / p) + ", gcd = " + Numbers.gcd(a,  b, c));
            a += a0;
            b += b0;
            sum += p;
        }
    }

    /**
     * use Heron's formula
     */
    private double area(int a, int b, int c) {
        double s = (a + b + c) / 2.0;    // semi-perimeter
        double d = s * (s - a) * (s - b) * (s - c);
        if(d <= 0) { // not a possible triangle
            return -1;
        }
        return Math.sqrt(d);
    }


}
