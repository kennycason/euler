package _010;

import lib.Numbers;


public class _010 {
	
	public static void main(String[] args) {
		new _010(2000000);
	}

	public _010(int n) {
		long sum = 0;
		for(int i = 0; i < n; i++) {
			if(Numbers.isPrime(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
