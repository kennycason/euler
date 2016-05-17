package problems;

import lib.Sequence;
import main.Problem;
import main.annotations.Solved;

import java.util.List;

@Solved
public class p002 extends Problem {

    public static void main(String[] args) {
        Problem p = new p002();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int max = 4000000;

        List<Long> seq = Sequence.fibonacciToMaxTerm(max);
        int sum = 0;
        for(Long i : seq) {
            if(i % 2 == 0) {
                sum += i;
            }
        }
        this.answer = sum;
    }

}
