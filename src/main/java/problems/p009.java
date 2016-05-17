package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p009 extends Problem {

    public static void main(String[] args) {
        Problem p = new p009();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int max = 1000;

        for(int a = 0; a <= max; a++) {
            for(int b = 0; b <= max; b++) {
                for(int c = 0; c <= max; c++) {
                    if(a + b + c == max) {
                        if(Numbers.isPythagoreanTriplet(a, b, c)) {
                            this.answer = a * b * c;
                        }
                    }
                }
            }
        }
    }

}
