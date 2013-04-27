package _072;

import lib.Numbers;


public class _072 {

	public static void main(String[] args) {
		new _072();
	}

	public _072() {
		int limit = 1000000;
		
		int count = 0;
		for(int d = 1; d <= limit; d++) {
			for(int n = 1; n < d; n++) {
				if(Numbers.gcd(n, d) == 1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
}
