package _046;

import lib.Numbers;
import lib.Primes;



public class _046 {

	public static void main(String[] args) {
		new _046();
	}

	public _046() {
		for(int i = 9; ; i += 2) {
			if(Numbers.isComposite(i)) {
				boolean found = false;
				for(int p = 0; Primes.PRIME_TABLE[p] < i; p++) {
					int mult = 0;
					int m = 1;
					do {
						mult = Primes.PRIME_TABLE[p] + 2 * m * m;
						if(mult == i) {
							// System.out.println(i + " = " + Primes.PRIME_TABLE[p] + " 2x" + m + "^2");
							found = true;
							break;
						}
						m++;
					} while(mult < i);
					if(found) {
						break;
					}
				}
				if(!found) {
					System.out.println(i);
					break;
				}
			}
		}
	}

}
