package _073;

import lib.Numbers;




public class _073 {

	public static void main(String[] args) {
		new _073();
	}

	public _073() {
		int a = 3; // 1/3
		int b = 2; // 1/2
		int count = 0;
		for (int d = 2; d <= 12000; d++) {
			// bound to prevent iterating over too much
		    for (int n = d / a + 1; n < (d - 1) / b + 1; n++) { 
		        if (Numbers.gcd(n, d) == 1) {
		        	count++;
		        }
		    }
		}
		System.out.println(count);
	}
	
}
