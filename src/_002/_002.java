package _002;

import java.util.List;

import lib.Sequence;
import main.AbstractProblem;

public class _002 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _002();
		p.run();
		System.out.println(p.answer());
	}
	
	public void run() {
		int max = 4000000;
		
		List<Long> seq = Sequence.fibonacciMaxTerm(max);
		int sum = 0;
		for(Long i : seq) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		this.answer = sum;
	}
	
}
