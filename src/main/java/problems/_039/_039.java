package problems._039;

import main.Problem;
import main.annotations.Solved;

@Solved
public class _039 extends Problem {

    public static void main(String[] args) {
        Problem p = new _039();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int maxN = 0;
        int maxSoln = 0;

        double c;
        int numSoln;
        for(int n = 1; n <= 1000; n++) {
            numSoln = 0;
            for(int a = 1; a < n / 2; a++) {
                for(int b = a; b < n / 2; b++) {
                    c = Math.sqrt(a * a + b * b);
                    if(a + b + c == n) {
                        numSoln++;
                    }
                }
            }
            if(numSoln > maxSoln) {
                maxSoln = numSoln;
                maxN = n;
            }
        }
        this.answer = maxN;
    }

}
