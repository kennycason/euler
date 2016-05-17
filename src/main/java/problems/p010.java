package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p010 extends Problem {

    public static void main(String[] args) {
        Problem p = new p010();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int n = 2000000;

        long sum = 0;
        for(int i = 0; i < n; i++) {
            if(Numbers.isPrime(i)) {
                sum += i;
            }
        }
        this.answer = sum;
    }

}
