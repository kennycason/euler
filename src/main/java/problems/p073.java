package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p073 extends Problem {

    public static void main(String[] args) {
        Problem p = new p073();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int a = 3; // 1/3
        int b = 2; // 1/2
        int count = 0;
        for (int d = 2; d <= 12000; d++) {
            // bound to prevent iterating over too much
            for (int n = d / a + 1; n < (d - 1) / b + 1; n++) {
                if (Numbers.gcd(n, d) == 1) {
                    count++;
                }
            }
        }
        this.answer = count;
    }

}
