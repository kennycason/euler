package _036;

import lib.Numbers;
import lib.Strings;
import main.AbstractProblem;




public class _036 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _036();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int sum = 0;
		for(int i = 0; i < 1000000; i++) {
			if(Numbers.isPalindrome(i) && 
					Strings.isPalindrome(Integer.toBinaryString(i))) {
				sum += i;
			}
		}
		this.answer = sum;
	}

}
