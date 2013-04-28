package _025;

import java.math.BigInteger;

import main.AbstractProblem;


public class _025 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _025();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		this.answer = fibonacciFirstOccurenceOfLength(1000);
	}	

	public int fibonacciFirstOccurenceOfLength(int length) {
		if(length < 2) {
			return 1;
		}
		BigInteger n1 = BigInteger.valueOf(1);
		BigInteger n2 = BigInteger.valueOf(1);
		int term = 2;
		BigInteger tmp;
		for(;;) {
			tmp = n1.add(n2);
			n1 = n2;
			n2 = tmp;
			term++;
			if(String.valueOf(n2).length() >= length) {
				return term;
			}
		}
	}
	
}
