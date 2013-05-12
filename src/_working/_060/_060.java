package _working._060;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lib.Numbers;
import lib.Sieve;
import main.AbstractProblem;

public class _060 extends AbstractProblem {

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
		List<Long> primesList = Sieve.eratosthenes(100000);
		Long[] primeArray = primesList.toArray(new Long[primesList.size()]);
		for(Long p : primesList) {
			primeSet.add(p);
		}
		
		long smallestSum = Integer.MAX_VALUE;
		for(;;) {
			for(int p1 = 0; p1 < primeArray.length; p1++) {
				for(int p2 = p1 + 1; p2 < primeArray.length; p2++) {
					for(int p3 = p2 + 1; p3 < primeArray.length; p3++) {
						for(int p4 = p3 + 1; p4 < primeArray.length; p4++) {
					//		System.out.println(primeArray[p1] + " " +  primeArray[p2] 
					//				+ " " +  primeArray[p3] + " " +  primeArray[p4]);
							if(primeSet.contains(concat(p1, p2))
								&& primeSet.contains(concat(p2, p1))
								&& primeSet.contains(concat(p1, p3))
								&& primeSet.contains(concat(p3, p1))
								&& primeSet.contains(concat(p1, p4))
								&& primeSet.contains(concat(p4, p1))
										
								&& primeSet.contains(concat(p2, p3))
								&& primeSet.contains(concat(p3, p2))
								&& primeSet.contains(concat(p2, p4))
								&& primeSet.contains(concat(p4, p2))
								
								&& primeSet.contains(concat(p3, p4))
								&& primeSet.contains(concat(p4, p3))
									) {
								long sum = primeArray[p1] + primeArray[p2] 
										+ primeArray[p3] + primeArray[p4];
								if(sum < smallestSum) {
									smallestSum = sum;
									System.out.println(sum + ": " + primeArray[p1] + " " +  primeArray[p2] 
											+" " +  primeArray[p3] + " " +  primeArray[p4]);
								}
							}
						}
					}
				}
			}
			return smallestSum;
		}
	}
	
	private long concat(long n, long n2) {
		n2 = Numbers.reverse(n2);
		while(n2 > 0) {
			n *= 10;
			n += n2 % 10;
			n2 /= 10;
		}
		return n;
	}
	
}
