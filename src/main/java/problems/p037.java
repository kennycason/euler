package problems;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.util.List;

@Solved
public class p037 extends Problem {

    public static void main(String[] args) {
        Problem p = new p037();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {

        List<Long> primes = Numbers.primes(739397);
        int sum = 0;
        for(Long prime : primes) {
            if(prime <= 7) {
                continue;
            }
            if(truncatableLtoR(prime) && truncatableRtoL(prime)) {
                sum += prime;
            }
        }
        this.answer = sum;
    }

    private boolean truncatableRtoL(Long prime) {
        while(prime > 0) {
            if(!Numbers.isPrime(prime)) {
                return false;
            }
            prime /= 10;
        }
        return true;
    }

    private boolean truncatableLtoR(Long prime) {
        int p = 16;
        while(p >= 0) {
            long pow = (long)Math.pow(10, p);
            if(pow <= prime) {
                if(!Numbers.isPrime(prime)) {
                    return false;
                }
                prime = prime % pow;
            }
            p--;
        }
        return true;
    }

}
