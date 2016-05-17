package problems;

import main.Problem;
import main.annotations.Solved;

@Solved
public class p001 extends Problem {

    public static void main(String[] args) {
        Problem p = new p001();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {

        int max = 1000;

        int sum = 0;
        for(int i = 1; i < max; i++) {
            if(i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        this.answer = sum;
    }

}
