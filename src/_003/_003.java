package _003;

import java.util.List;

import lib.ListAlgo;
import lib.Numbers;

public class _003 {

	public static void main(String[] args) {
		new _003();
	}

	public _003() {
		long n = 600851475143l;
		
		List<Long> seq = Numbers.primeFactors(n);
		Numbers.filterNonPrime(seq);
		System.out.println(ListAlgo.max(seq));
	}
	
}
