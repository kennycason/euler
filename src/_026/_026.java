package _026;

import main.AbstractProblem;


public class _026 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _026();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		/**
		 * observational notes note that the maximum recurring cycle length of
		 * 1/d is d-1
		 */

		int sequenceLength = 0;
		int i = 0;
		for (i = 1000; i > 1; i--) {
			if (sequenceLength >= i) {
				break;
			}

			int[] foundRemainders = new int[i];
			int value = 1;
			int position = 0;

			while (foundRemainders[value] == 0 && value != 0) {
				foundRemainders[value] = position;
				value *= 10;
				value %= i;
				position++;
			}

			if (position - foundRemainders[value] > sequenceLength) {
				sequenceLength = position - foundRemainders[value];
			}
		}
		this.answer = sequenceLength + 1; 
	}

}
