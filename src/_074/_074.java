package _074;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lib.Numbers;





public class _074 {

	public static void main(String[] args) {
		new _074();
	}

	public _074() {
		int count = 0;
		for(long i = 1; i < 1000000; i++) {
			long sum = sumFactorialOfDigits(Numbers.getDigits(i));
			Set<Long> chain = new HashSet<Long>();
			chain.add(i);
			while(!chain.contains(sum)) {
				chain.add(sum);
				sum = sumFactorialOfDigits(Numbers.getDigits(sum));
			}
			if(chain.size() == 60) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	private long sumFactorialOfDigits(List<Integer> digits) {
		long sum = 0;
		for(Integer d : digits) {
			sum += Numbers.factorial(d);
		}
		return sum;
	}
}
