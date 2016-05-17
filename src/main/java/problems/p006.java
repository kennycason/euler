package problems;

import main.Problem;
import main.annotations.Solved;

@Solved
public class p006 extends Problem {

    public static void main(String[] args) {
        Problem p = new p006();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int n = 100;
        this.answer = squareOfSums(n) - sumOfSquares(n);
    }

    private long sumOfSquares(int n) {
        long sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i * i;
        }
        return sum;
    }

    private long squareOfSums(int n) {
        long sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum * sum;
    }

}
