package _002;

import java.util.List;

import lib.Sequence;

public class _002 {

	public static void main(String[] args) {
		new _002(4000000);
	}

	public _002(int max) {
		List<Integer> seq = Sequence.fibonacciMaxTerm(max);
		int sum = 0;
		for(Integer i : seq) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}
	
}
