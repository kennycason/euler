package _005;

import main.AbstractProblem;

public class _005 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _005();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		for(int i = 20; i < Integer.MAX_VALUE; i++) {
			if(divisable(i)) {
				this.answer = i;
				break;
			}
		}
	}
	
	/**
	 * full range: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
	 * optimize array:
	 * if n % 20 == 0, then n % 10 == 0 and n % 5 == 0 and n % 2 == 0, 
	 *    therefore cut out 10, 5, and 2
	 *    [11, 12, 13, 14, 15, 16, 17, 18, 19, 20]
	 */
	private boolean divisable(int n) {
		for(int i = 11; i <= 20; i++) {
			if(n % i != 0) {
				return false;
			}
		}
		return true;
	}
	
}
