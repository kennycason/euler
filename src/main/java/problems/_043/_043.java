package problems._043;

import lib.Numbers;
import lib.Primes;
import lib.Sequence;
import main.Problem;
import main.annotations.Solved;

@Solved
public class _043 extends Problem {

    public static void main(String[] args) {
        Problem p = new _043();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        long sum = 0;
        for (String s : Sequence.permutation("0123456789")) {
            long i = Long.parseLong(s);
            boolean divisible = true;
            for (int d = 1; d <= 7; d++) {

                int n = Numbers.getNthDigit(i, s.length() - d) * 100
                        + Numbers.getNthDigit(i, s.length() - d - 1) * 10
                        + Numbers.getNthDigit(i, s.length() - d - 2);

                if (n % Primes.PRIME_TABLE[d - 1] != 0) {
                    divisible = false;
                    break;
                }
            }
            if (divisible) {
                sum += i;
            }
        }
        this.answer = sum;
    }

}
