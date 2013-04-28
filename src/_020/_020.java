package _020;

import java.math.BigInteger;

import lib.Numbers;
import main.AbstractProblem;


public class _020 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _020();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int sum = 0;
		BigInteger n = Numbers.bigFactorial(100);
		for(String d : n.toString().split("(?!^)")) {
			sum += Integer.parseInt(d);
		}
		this.answer = sum;
	}

}
