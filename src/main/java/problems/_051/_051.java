package problems._051;

import lib.Numbers;
import lib.Sieve;
import main.Problem;
import main.annotations.Solved;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Solved
public class _051 extends Problem {

	public static void main(String[] args) {
		Problem p = new _051();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		List<Long> primes = Sieve.eratosthenes(500000);
		// List<Long> primes = new LinkedList<Long>();
		// primes.add(56003l);
		int primeFamily = 8;
		Set<Integer> digits = new HashSet<Integer>();
		for (long prime : primes) {
			int numDigits = Numbers.numDigits(prime);
			// replace one digit
			for (int i = 1; i < numDigits; i++) {
				for (int j = 1; j < numDigits; j++) {
					for (int k = 1; k < numDigits; k++) {
						digits.clear();
						digits.add(i);
						digits.add(j);
						digits.add(k);
						if (testN(prime, digits, primeFamily)) {
							this.answer = prime;
							return;
						}
					}
				}
			}
		}
	}

	private boolean testN(long n, Set<Integer> digits, int primeFamily) {
		int count = 0;
		int numDigits = Numbers.numDigits(n);
		boolean familyContainsN = false; // <-- this is IMPORTANT, "Find the smallest prime which is PART of an eight prime value family"
		for (int d = 0; d < 10; d++) {
			long n2 = replaceDigit(n, digits, d);
			if (Numbers.isPrime(n2) && Numbers.numDigits(n2) == numDigits) {
				if(n2 == n) {
					familyContainsN = true;
				}
				count++;
			}
		}
		return familyContainsN && count == primeFamily;
	}

	private long replaceDigit(long n, Set<Integer> digits, int val) {
		if (val > 9) {
			return n;
		}
		int n2 = 0;
		int mult = 1;
		int c = 0;
		while (n > 0) {
			if (digits.contains(c)) {
				n2 += (mult * val);
			} else {
				n2 += mult * (n % 10);
			}
			mult *= 10;
			n /= 10;
			c++;
		}
		return n2;
	}

}
