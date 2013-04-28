package _009;

import lib.Numbers;
import main.AbstractProblem;


public class _009 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _009();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int max = 1000;
		
		for(int a = 0; a <= max; a++) {
			for(int b = 0; b <= max; b++) {
				for(int c = 0; c <= max; c++) {
					if(a + b + c == max) {
						if(Numbers.isPythagoreanTriplet(a, b, c)) {
							this.answer = a * b * c;
						}
					}
				}
			}
		}
	}
	
}
