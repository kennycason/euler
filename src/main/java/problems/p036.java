package problems;

import lib.Numbers;
import lib.Strings;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p036 extends Problem {

    public static void main(String[] args) {
        Problem p = new p036();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int sum = 0;
        for(int i = 0; i < 1000000; i++) {
            if(Numbers.isPalindrome(i) &&
                    Strings.isPalindrome(Integer.toBinaryString(i))) {
                sum += i;
            }
        }
        this.answer = sum;
    }

}
