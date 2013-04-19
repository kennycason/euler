package _023;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import lib.Numbers;


public class _023 {

	public static void main(String[] args) {
		new _023();
	}
	

	public _023() {
		List<Long> abundants = new LinkedList<Long>();
		for(long i = 12; i <= 28123; i++) {
			if(Numbers.isAbundant(i)) {
				abundants.add(i);
			}
		}
		// System.out.println(abundants.size());
		// System.out.println(abundants);
		
		HashSet<Long> canSum = new HashSet<Long>();
		
		for(long a : abundants) {
			for(long b : abundants) {
				canSum.add(a + b);
			}
		}

		int sum = 0;
		for(long i = 1; i <= 28123; i++) {
			if(!canSum.contains(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	

}
