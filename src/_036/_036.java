package _036;

import lib.Numbers;
import lib.Strings;




public class _036 {

	public static void main(String[] args) {
		new _036();
	}

	public _036() {
		int sum = 0;
		for(int i = 0; i < 1000000; i++) {
			if(Numbers.isPalindrome(i) && 
					Strings.isPalindrome(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
