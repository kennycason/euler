package _002;

import java.util.List;

import lib.Sequence;

public class _002 {

	public static void main(String[] args) {
		new _002();
	}

	public _002() {
		int max = 4000000;
		
		List<Long> seq = Sequence.fibonacciMaxTerm(max);
		int sum = 0;
		for(Long i : seq) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
}
