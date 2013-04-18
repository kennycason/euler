package _007;

import lib.Numbers;

public class _007 {
	
	public static void main(String[] args) {
		new _007();
	}

	public _007() {
		int n = 10001;
		
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
