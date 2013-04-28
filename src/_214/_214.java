package _214;

import java.util.List;

import lib.DynamicAlgorithms;
import lib.Sieve;


public class _214 {
	
	
	public static void main(String[] args) {
		new _214();
	}

	public _214() {
		long sum = 0;
		long[] totientSums = DynamicAlgorithms.totientSums(40000000 - 1);
		List<Long> primes = Sieve.eratosthenes(40000000 - 1);
		for(long p : primes) {
			int chain = 1;
			int i = (int)p;
			while(i > 1) {
				i = (int)totientSums[i];
				chain++;
			}
			if(chain == 25) {
				sum += p;
			}
		}
		System.out.println(sum);
	}
	
}
