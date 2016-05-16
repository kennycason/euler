package problems._187;

import lib.Sieve;
import main.Problem;
import main.annotations.Solved;

import java.util.List;

@Solved
public class _187 extends Problem {

    public static void main(String[] args) {
        Problem p = new _187();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        long limit = 100000000;
        int count = 0;
        List<Long> primesList = Sieve.eratosthenes(55000000); // seems to be the upper bound of needed primes
        Long[] primes = primesList.toArray(new Long[primesList.size()]);
        for(int i = 0; i < primes.length; i++) {
            long upper = limit / primes[i];
            for(int j = i; j < primes.length && j < upper; j++) {
                if(primes[i] * primes[j] >= limit) {
                    break;
                }
                count++;
            }
        }
        this.answer = count;
    }

}
