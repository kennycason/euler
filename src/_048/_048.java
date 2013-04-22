package _048;

import java.math.BigInteger;

import lib.Numbers;
import lib.Probability;




public class _048 {

	public static void main(String[] args) {
		new _048();
	}

	public _048() {
		BigInteger sum = BigInteger.ZERO;
		
		for(int n = 1; n <= 1000; n++) {
			sum = sum.add(Numbers.bigPow(n, n));
		}
		String nStr = sum.toString();
		System.out.println(nStr.substring(nStr.length() - 10));
	}

}
