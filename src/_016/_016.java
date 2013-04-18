package _016;

import java.math.BigInteger;

import lib.Numbers;

public class _016 {
	
	
	public static void main(String[] args) {
		new _016();
	}
	
	public _016() {
		int exp = 1000;
		BigInteger n = Numbers.bigPow(2, exp);
		String digits = n.toString();
		int sum = 0;
		for(int i = 0; i < digits.length(); i++) {
			sum += Integer.valueOf(String.valueOf((digits.charAt(i))));
		}
		System.out.println(sum);
	}
	
}
