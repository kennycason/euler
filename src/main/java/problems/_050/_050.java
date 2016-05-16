package problems._050;

import lib.Numbers;
import lib.Primes;
import main.Problem;
import main.annotations.Solved;

import java.util.List;

@Solved
public class _050 extends Problem {

    public static void main(String[] args) {
        Problem p = new _050();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        // faster approach
        int max = 999999;
        // first 546 primes form the longest consecutive sum that is less than 1,000,000 is of size 546
        // 21 provided as a min in problem
        for (int consecutive = 546; consecutive >= 21; consecutive--) {
            for(int j = 0; j < 10; j++) {
                int sum = 0;
                for (int i = j; i < consecutive; i++) {
                    sum += Primes.PRIME_TABLE[i];
                }
                if (sum <= max && Numbers.isPrime(sum)) {
                    this.answer = sum;
                    return;
                }
            }
        }
    }

    /**
     * my first, bad soln
     */
    @SuppressWarnings("unused")
    private void soln1() {
        List<Long> primes = Numbers.primes(999999);
        long maxPrime = 0;
        int longestSum = 0;

        for(Long prime : primes) {
            /* optimized to only look at first 546 primes as the smallest
             consecutive sum that is less than 1,000,000 is of size 546 */
            for(int i = 546; i >= 0 && Primes.PRIME_TABLE[i] <= prime; i--) {
                int sum = 0;
                int consecutive = 0;
                for(int j = 0; sum < prime && (i + j) <= 546; j++) {
                    sum += Primes.PRIME_TABLE[i + j];
                    consecutive++;
                    //System.out.println(prime + " (+" + Numbers.PRIME_TABLE[i + j] + ") " + sum);
                    if(sum == prime && consecutive > longestSum) {
                        longestSum = consecutive;
                        maxPrime = prime;
                    }
                }
            }
        }
        System.out.println(maxPrime);
    }

}
