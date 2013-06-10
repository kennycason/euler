package _working._060;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lib.Numbers;
import lib.Sieve;
import main.AbstractProblem;

public class _060 extends AbstractProblem {

	private Set<Long> memoized = new HashSet<Long>();
	
	public static void main(String[] args) {
		AbstractProblem p = new _060();
		p.run();
		System.out.println(p.answer());
	}
	
	public void run() {
		this.answer = smallestSum();
	}
	
	private long smallestSum() {
	
		Set<Long> primeSet = new HashSet<Long>();
		List<Long> primePairList = Sieve.eratosthenes(30000);
		Long[] primes = primePairList.toArray(new Long[primePairList.size()]);
		primeSet.addAll(primePairList);

		long smallestSum = Long.MAX_VALUE;
		for(int p1 = 1; p1 < primes.length; p1++) {
			for(int p2 = p1 + 1; p2 < primes.length; p2++) {
				for(int p3 = p2 + 1; p3 < primes.length; p3++) {
					for(int p4 = p3 + 1; p4 < primes.length; p4++) {
						for(int p5 = p4 + 1; p5 < primes.length; p5++) {
							// p1 = 5; p2 = 691; p3 = 750; p4 = 867; p5 = 1050;
						    // System.out.println(primes[p1] + " " + primes[p2] + " " + primes[p3] + " " + primes[p4] + " " + primes[p5]);
							if(memoizedIsPrime(Numbers.concat(primes[p1], primes[p2]))
								&& memoizedIsPrime(Numbers.concat(primes[p1], primes[p3]))
								&& memoizedIsPrime(Numbers.concat(primes[p1], primes[p4]))
								&& memoizedIsPrime(Numbers.concat(primes[p1], primes[p5]))
								
								&& memoizedIsPrime(Numbers.concat(primes[p2], primes[p1]))							
								&& memoizedIsPrime(Numbers.concat(primes[p2], primes[p3]))
								&& memoizedIsPrime(Numbers.concat(primes[p2], primes[p4]))
								&& memoizedIsPrime(Numbers.concat(primes[p2], primes[p5]))
								
								&& memoizedIsPrime(Numbers.concat(primes[p3], primes[p1]))
								&& memoizedIsPrime(Numbers.concat(primes[p3], primes[p2]))
								&& memoizedIsPrime(Numbers.concat(primes[p3], primes[p4]))
								&& memoizedIsPrime(Numbers.concat(primes[p3], primes[p5]))
								
								&& memoizedIsPrime(Numbers.concat(primes[p4], primes[p1]))
								&& memoizedIsPrime(Numbers.concat(primes[p4], primes[p2]))
								&& memoizedIsPrime(Numbers.concat(primes[p4], primes[p3]))
								&& memoizedIsPrime(Numbers.concat(primes[p4], primes[p5]))
								
								&& memoizedIsPrime(Numbers.concat(primes[p5], primes[p1]))
								&& memoizedIsPrime(Numbers.concat(primes[p5], primes[p2]))
								&& memoizedIsPrime(Numbers.concat(primes[p5], primes[p3]))
								&& memoizedIsPrime(Numbers.concat(primes[p5], primes[p4]))			
									) {
							    // System.out.println("ALL PRIME!" + primes[p1] + " " + primes[p2] + " " + primes[p3] + " " + primes[p4] + " " + primes[p5]);// + " " + primes[p5]);
								long sum = primes[p1] + primes[p2] + primes[p3] + primes[p4] + primes[p5];
								if(sum < smallestSum) {
									smallestSum = sum;
									System.out.println("Smallest Sum: " + sum);
								}
							}
						}
					}
				}
			}
		}
		return smallestSum;
	}
	
	public boolean memoizedIsPrime(long n) {
		if(memoized.contains(n)) {
			return true;
		}
		if(Numbers.isPrime(n)) {
			memoized.add(n);
			return true;
		}
		return false;
	}
	
	
}
