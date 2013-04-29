package _101;

import lib.fn.Polynomial;
import lib.fn.Term;
import main.AbstractProblem;




public class _101 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _101();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		long sum = 0;
		Polynomial p = new Polynomial(new Term(1), new Term(-1, 1), new Term(1, 2), new Term(-1, 3), new Term(1, 4), new Term(-1, 5), 
				new Term(1, 6), new Term(-1, 7), new Term(1, 8), new Term(-1, 9), new Term(1, 10));

		for(int i = 1; i <= 4; i++) {
			System.out.println(i + ": " + p.eval(i));
		}
		this.answer = sum;
	}
	
}
