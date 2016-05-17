package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p058 extends Problem {

    public static void main(String[] args) {
        Problem p = new p058();
        p.run();
        System.out.println(p.answer());
    }

    /**
     * 37 36 35 34 33 32 31
     * 38 17 16 15 14 13 30
     * 39 18  5  4  3 12 29
     * 40 19  6  1  2 11 28
     * 41 20  7  8  9 10 27
     * 42 21 22 23 24 25 26
     * 43 44 45 46 47 48 49
     *
     * refer to notes for derivative explanation
     */
    public void run() {
        int ur = 3, ul = 5, dl = 7, dr = 9;
        int dur = 2, dul = 4, ddl = 6, ddr = 8;
        int d2d = 8; // all share same 2nd derivative
        int nPrime = 3;
        int n = 5; // include center
        int length = 3;
        for(;;) {
            double ratio = (double)nPrime / n;
            if(ratio < 0.10) {
                this.answer = length;
                break;
            }
            // add 2nd deriv to 1st deriv
            dur += d2d;
            dul += d2d;
            ddl += d2d;
            ddr += d2d;
            // add 2st deriv to 2nd
            ur += dur;
            ul += dul;
            dl += ddl;
            dr += ddr;

            if(Numbers.isPrime(ur)) {
                nPrime++;
            }
            if(Numbers.isPrime(ul)) {
                nPrime++;
            }
            if(Numbers.isPrime(dl)) {
                nPrime++;
            }
            if(Numbers.isPrime(dr)) {
                nPrime++;
            }
            n += 4;
            length += 2;
        }
    }

}
