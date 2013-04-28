package _214;

import java.util.List;

import lib.DynamicAlgorithms;
import lib.Sieve;
import main.AbstractProblem;


public class _214 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _214();
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
