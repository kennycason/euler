package _055;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import lib.Numbers;




public class _055 {
	
	
	public static void main(String[] args) {
		new _055();
	}

	public _055() {
		long count = 0;
		long limit = 10000;
		for(long i = 10; i < limit; i++) {
			boolean cycleFound = false;
			List<BigInteger> ns = new LinkedList<BigInteger>();
			BigInteger n = BigInteger.valueOf(i);
			for(long j = 0; j < 50; j++) {
				BigInteger r = Numbers.reverse(n);
				ns.add(n);
				BigInteger sum = n.add(r);
				if(Numbers.isPalindrome(sum)) {
					ns.add(sum);
					cycleFound = true;
					break;
				}
				n = sum;
			}
			if(!cycleFound) {
				count++;
			}
		}
		System.out.println(count);
	}
	
}
