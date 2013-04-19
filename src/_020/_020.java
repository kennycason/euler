package _020;

import java.math.BigInteger;

import lib.Numbers;


public class _020 {

	public static void main(String[] args) {
		new _020();
	}

	public _020() {
		int sum = 0;
		BigInteger n = Numbers.bigFactorial(100);
		for(String d : n.toString().split("(?!^)")) {
			sum += Integer.parseInt(d);
		}
		System.out.println(sum);
	}

}
