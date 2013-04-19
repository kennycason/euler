package _021;

import java.util.LinkedList;
import java.util.List;

import lib.Numbers;


public class _021 {

	public static void main(String[] args) {
		new _021();
	}

	public _021() {
		List<Long> amicable = new LinkedList<Long>();
		for(long i = 2; i < 10000; i++) {
			if(isAmicable(i)) {
				amicable.add(i);
			}
		}
		System.out.println(Numbers.sum(amicable));
	}
	
	private long d(long n) {
		List<Long> divisors = Numbers.properDivisors(n);
		return Numbers.sum(divisors);
	}
	
	private boolean isAmicable(long a) {
		long b = d(a);
		if(a == b) {
			return false;
		}
		if(d(b) == a) {
			return true;
		}
		return false;
	}

}
