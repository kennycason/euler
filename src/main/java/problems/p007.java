package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p007 extends Problem {

    public static void main(String[] args) {
        Problem p = new p007();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        int n = 10001;

        int found = 0;
        for(int i = 0; ; i++) {
            if(Numbers.isPrime(i)) {
                found++;
                if(found == n) {
                    this.answer = i;
                    break;
                }
            }
        }
    }

}
