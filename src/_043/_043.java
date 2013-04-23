package _043;

import lib.Numbers;
import lib.Sequence;

public class _043 {

	public static void main(String[] args) {
		new _043();
	}

	public _043() {

		long sum = 0;
		for (String s : Sequence.permutation("0123456789")) {
			long i = Long.parseLong(s);
			boolean divisible = true;
			for (int d = 1; d <= 7; d++) {
				
				int n = Numbers.getNthDigit(i, s.length() - d) * 100
						+ Numbers.getNthDigit(i, s.length() - d - 1) * 10
						+ Numbers.getNthDigit(i, s.length() - d - 2);
				
				if (n % Numbers.PRIME_TABLE[d - 1] != 0) {
					divisible = false;
					break;
				}
			}
			if (divisible) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
