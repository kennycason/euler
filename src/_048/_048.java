package _048;

import java.math.BigInteger;

import lib.Numbers;
import main.AbstractProblem;




public class _048 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _048();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		BigInteger sum = BigInteger.ZERO;
		
		for(int n = 1; n <= 1000; n++) {
			sum = sum.add(Numbers.bigPow(n, n));
		}
		String nStr = sum.toString();
		this.answer = nStr.substring(nStr.length() - 10);
	}

}
