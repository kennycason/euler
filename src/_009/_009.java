package _009;

import lib.Numbers;


public class _009 {
	
	
	public static void main(String[] args) {
		new _009(5);
	}

	public _009(int n) {
		for(int a = 0; a <= 1000; a++) {
			for(int b = 0; b <= 1000; b++) {
				for(int c = 0; c <= 1000; c++) {
					if(a + b + c == 1000) {
						if(Numbers.isPythagoreanTriplet(a, b, c)) {
							System.out.println(a * b * c);
						}
					}
				}
			}
		}
	}
	

	
}
