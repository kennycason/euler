package problems;

import main.Problem;
import main.annotations.Solved;

@Solved
public class p063 extends Problem {

    public static void main(String[] args) {
        Problem p = new p063();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int count = 0;
        for(int b = 1; b < 10; b++) {
            for(int p = 1; p < 25; p++) {
                double n = Math.pow(b, p);
                int digits = (int) Math.log10(n) + 1;
                if(p > digits) {
                    break;
                }
                if(digits == p) {
                    count++;
                }
            }
        }
        this.answer = count;
    }

}
