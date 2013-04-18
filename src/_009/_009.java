package _009;

import lib.Numbers;


public class _009 {
	
	
	public static void main(String[] args) {
		new _009();
	}

	public _009() {
		int max = 1000;
		
		for(int a = 0; a <= max; a++) {
			for(int b = 0; b <= max; b++) {
				for(int c = 0; c <= max; c++) {
					if(a + b + c == max) {
						if(Numbers.isPythagoreanTriplet(a, b, c)) {
							System.out.println(a * b * c);
						}
					}
				}
			}
		}
	}
	

	
}
