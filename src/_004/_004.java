package _004;

import lib.Numbers;

public class _004 {
	
	public static void main(String[] args) {
		new _004(3);
	}

	public _004(int digits) {
		int upper = (int)Math.pow(10, digits) - 1;
		int max = 0;
		int mult = 0;
		for(int i = 0; i <= upper; i++) {
			for(int j = 0; j <= upper; j++) {
				mult = i * j;
				if(Numbers.isPalindrome(mult) && mult > max) {
					max = mult;
				}
			}		
		}
		System.out.println(max);
	}
	
	
}
