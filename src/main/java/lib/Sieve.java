package lib;

import java.util.ArrayList;
import java.util.List;

public class Sieve {

    private Sieve() {
    }

    public static List<Long> eratosthenes(final int to) {
        final List<Long> primes = new ArrayList<>();
        primes.add(2L);
        final long[] numbers = Numbers.enumerate(3, to, 2);
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] > 0 && Numbers.isPrime(numbers[i])) {
                primes.add(numbers[i]);
                // flag multiples
                final long step = numbers[i];
                for(int j = i; j < numbers.length; j += step)  {
                    numbers[j] = 0;
                }
            }
        }
        return primes;
    }

}
