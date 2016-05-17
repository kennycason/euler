package problems;

import lib.ListAlgo;
import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.util.List;

@Solved
public class p003 extends Problem {

    public static void main(String[] args) {
        Problem p = new p003();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        long n = 600851475143l;
        List<Long> seq = Numbers.distinctPrimeFactors(n);
        this.answer = ListAlgo.max(seq);
    }

}
