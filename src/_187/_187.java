package _187;

import java.util.List;

import lib.Sieve;




public class _187 {
	
	
	public static void main(String[] args) {
		new _187();
	}

	public _187() {
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
		System.out.println(count);
	}
	
}
