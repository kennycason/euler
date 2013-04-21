package _027;

import lib.Numbers;


public class _027 {

	public static void main(String[] args) {
		new _027();
	}

	public _027() {
		int maxA = 0;
		int maxB = 0;
		int max = 0;
		int count = 0;
		for(int a = -999; a <= 999; a++) {
			for(int b = -999; b <= 999; b++) {
				count = consecutivePrimes(a, b);
				if(count > max) {
					maxA = a;
					maxB = b;
					max = count;
					System.out.println(a + " " + b + " = " + count);
				}
				
			}	
		}
		System.out.println(maxA * maxB);
	}
	
	private int consecutivePrimes(int a, int b) {
		int count = 0;
		for(int n = 0; ; n++) {
			int fnab = n*n + a * n + b;
			if(Numbers.isPrime(fnab)) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

}
