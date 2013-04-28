package _016;

import java.math.BigInteger;

import lib.Numbers;
import main.AbstractProblem;

public class _016 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _016();
		p.run();
		System.out.println(p.answer());
	}
	
	public void run() {
		int exp = 1000;
		BigInteger n = Numbers.bigPow(2, exp);
		String digits = n.toString();
		int sum = 0;
		for(int i = 0; i < digits.length(); i++) {
			sum += Integer.valueOf(String.valueOf((digits.charAt(i))));
		}
		this.answer = sum;
	}
	
}
