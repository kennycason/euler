package _071;

import lib.Fraction;
import lib.Numbers;

public class _071 {

	public static void main(String[] args) {
		new _071();
	}

	/**
	 * want to find a n/d such that it's less thats 3/7
	 * n/d < 3/7
	 * 7n < 3d
	 */
	public _071() {
		int n2 = 3;
		int d2 = 7;
		//int n = 0;
		//int d = 1;
		
		//System.out.println(n + "/" + d);
		
		// brute force
		Fraction target = new Fraction(3, 7);
		Fraction leftOf = new Fraction(0, 1);
		for(int d = 1; d <= 1000000; d+=2) {
			for(int n = 1; n < d; n++) {
				if((double)n/d >= (double)3/7) {
					break;
				}
				if((double)n/d < (double)leftOf.getNumerator() / leftOf.getDenominator()) {
					continue;
				}
				if(Numbers.gcd(n, d) == 1) {
					Fraction f = new Fraction(n, d);
					if(f.compareTo(target) < 0 && f.compareTo(leftOf) > 0) {
						leftOf = f;
					}
				}
			}
		}
		System.out.println(leftOf);
	}
	
}
