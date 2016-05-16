package problems._041;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class _041 extends Problem {

    public static void main(String[] args) {
        Problem p = new _041();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        // only go to four because we know that 2143 is a 4-digit prime number, pan-digital
        for(int n = 9; n >=4; n--) {
            int max = Numbers.maxPanDigit(n);
            int min = Numbers.minPanDigit(n);
            for(int i = max; i >= min; i -= 2) { // skip even numbers
                if(Numbers.is1ToNPanDigit(i, n) &&
                        Numbers.isPrime(i)) {
                    this.answer = i;
                    return;
                }
            }
        }
    }


}
