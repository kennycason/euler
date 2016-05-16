package problems._033;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class _033 extends Problem {

    public static void main(String[] args) {
        Problem p = new _033();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int nf = 1;
        int df = 1;
        int n2, d2;
        for(int n = 1; n < 100; n++) {
            for(int d = n + 1; d < 100; d++) {
                for(int i = 0; i < 10; i++) {
                    if(n == d || (n % 10 == 0 && d % 10 == 0)) {
                        continue;
                    }
                    if(containsDigit(n, i) && containsDigit(d, i)) {
                        n2 = strip(n, i);
                        d2 = strip(d, i);
                        // System.out.println(n + " " + d + " strip " + i + " => " + n2 + " " + d2);
                        if(equals((double) n / d, (double) n2 / d2 , 0.001)) {
                            // System.out.println(n + " / " + d);
                            nf *= n;
                            df *= d;
                        }
                    }
                }
            }
        }
        this.answer = df / Numbers.gcd(nf, df);
    }

    private int strip(int n, int digit) {
        int i = 0;
        int m = 1;
        while(n > 0) {
            if(n % 10 != digit) {
                i += m * (n % 10);
                m *= 10;
            }
            n /= 10;
        }
        if(i == 0) {
            i = 1;
        }
        return i;
    }

    private boolean equals(double a, double b, double delta) {
        return Math.abs(a - b) < delta;
    }

    private boolean containsDigit(int n, int digit) {
        while(n > 0) {
            if(n % 10 == digit) {
                return true;
            }
            n /= 10;
        }
        return false;
    }

}
