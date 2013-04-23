package _041;

import lib.Numbers;




public class _041 {

	public static void main(String[] args) {
		new _041();
	}

	public _041() {
		// only go to four because we know that 2143 is a 4-digit prime number, pan-digital
		for(int n = 9; n >=4; n--) {
			int max = Numbers.maxPanDigit(n);
			int min = Numbers.minPanDigit(n);
			for(int i = max; i >= min; i -= 2) { // skip even numbers
				if(Numbers.is1ToNPanDigit(i, n) && 
						Numbers.isPrime(i)) {
					System.out.println(i);
					return; // break as early as possible	
				}
			}
		}
	}


}
