package problems._214;

import lib.DynamicAlgorithms;
import lib.Sieve;
import main.Problem;
import main.annotations.Solved;

import java.util.List;

@Solved
public class _214 extends Problem {

	public static void main(String[] args) {
		Problem p = new _214();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
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
		this.answer = sum;
	}
	
}
