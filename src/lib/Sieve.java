package lib;

import java.util.LinkedList;
import java.util.List;

public class Sieve {

	private Sieve() {
	}
	
	public static List<Long> eratosthenes(int to) {
		List<Long> primes = new LinkedList<Long>();
		
		long[] numbers = Numbers.enumerate(2, to);
		
		for(int i = 0; i < numbers.length; i++) {
			if(numbers[i] > 0 && Numbers.isPrime(numbers[i])) {
				primes.add(numbers[i]);
				// flag multiples
				long step = numbers[i];
				for(int j = i; j < numbers.length; j += step)  {
					numbers[j] = 0;
				}
			}
		}
		return primes;
	}
	
}
