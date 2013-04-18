package _007;

import lib.Numbers;

public class _007 {
	
	public static void main(String[] args) {
		new _007(10001);
	}

	public _007(int n) {
		int found = 0;
		for(int i = 0; ; i++) {
			if(Numbers.isPrime(i)) {
				found++;
				if(found == n) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
}
