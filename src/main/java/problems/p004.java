package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p004 extends Problem {

    public static void main(String[] args) {
        Problem p = new p004();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int digits = 3;

        int upper = (int)Math.pow(10, digits) - 1;
        int max = 0;
        int mult = 0;
        for(int i = 0; i <= upper; i++) {
            for(int j = 0; j <= upper; j++) {
                mult = i * j;
                if(Numbers.isPalindrome(mult) && mult > max) {
                    max = mult;
                }
            }
        }
        this.answer = max;
    }

}
