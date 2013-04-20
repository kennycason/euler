package _025;

import java.math.BigInteger;


public class _025 {
	
	public static void main(String[] args) {
		new _025();
	}

	public _025() {
		System.out.println(fibonacciFirstOccurenceOfLength(1000));
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
