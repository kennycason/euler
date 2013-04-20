package _026;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import lib.Numbers;

public class _026 {

	public static void main(String[] args) {
		new _026();
	}

	public _026() {
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
		System.out.println(sequenceLength + 1);
	}

}
