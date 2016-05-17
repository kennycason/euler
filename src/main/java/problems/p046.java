package problems;

import lib.Numbers;
import lib.Primes;
import main.Problem;
import main.annotations.Solved;

@Solved
public class p046 extends Problem {

    public static void main(String[] args) {
        Problem p = new p046();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        for(int i = 9; ; i += 2) {
            if(Numbers.isComposite(i)) {
                boolean found = false;
                for(int p = 0; Primes.PRIME_TABLE[p] < i; p++) {
                    int mult = 0;
                    int m = 1;
                    do {
                        mult = Primes.PRIME_TABLE[p] + 2 * m * m;
                        if(mult == i) {
                            // System.out.println(i + " = " + Primes.PRIME_TABLE[p] + " 2x" + m + "^2");
                            found = true;
                            break;
                        }
                        m++;
                    } while(mult < i);
                    if(found) {
                        break;
                    }
                }
                if(!found) {
                    this.answer = i;
                    break;
                }
            }
        }
    }

}
