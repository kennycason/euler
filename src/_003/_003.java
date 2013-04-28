package _003;

import java.util.List;

import lib.ListAlgo;
import lib.Numbers;
import main.AbstractProblem;

public class _003 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _003();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		long n = 600851475143l;
		List<Long> seq = Numbers.distinctPrimeFactors(n);
		this.answer = ListAlgo.max(seq);
	}
	
}
