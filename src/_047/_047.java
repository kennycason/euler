package _047;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lib.Numbers;


public class _047 {

	public static void main(String[] args) {
		new _047();
	}

	public _047() {
		int consecutiveGoal = 4;
		int distinctPrimeFactorGoal = 4;
		
		int consecutive = 0;
		for(int i = 2; ; i++) {
			List<Long> factors =  Numbers.primeFactors(i); 
			if(onlyNDistinctPrimeFactors(factors, distinctPrimeFactorGoal)) {
				consecutive++;
			} else {
				consecutive = 0;
			}
			if(consecutive == consecutiveGoal) {
				System.out.println(i - consecutiveGoal + 1);
				// System.out.println(factors);
				break;
			}
		}
	}
	
	private boolean onlyNDistinctPrimeFactors(List<Long> factors, int n) {
		Set<Long> set = new HashSet<Long>();
		for(Long factor : factors) {
			if(!Numbers.isPrime(factor)) {
				return false;
			}
			set.add(factor);
		}
		return set.size() == n;
	} 

}
