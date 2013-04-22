package _037;

import java.util.List;

import lib.Numbers;


public class _037 {

	public static void main(String[] args) {
		new _037();
	}

	public _037() {

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
		
		System.out.println("\n" + sum);
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
