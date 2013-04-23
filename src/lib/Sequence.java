package lib;

import java.util.LinkedList;
import java.util.List;

public class Sequence {

	private Sequence() {

	}

	public static List<Integer> fibonacci(int terms) {
		LinkedList<Integer> seq = new LinkedList<Integer>();
		if (terms == 0) {
			return seq;
		}
		seq.add(1);
		if (terms == 1) {
			return seq;
		}
		seq.add(2);

		int n1 = 1;
		int n2 = 2;
		for (int i = 0; i < terms - 2; i++) {
			seq.add(n1 + n2);
			n1 = n2;
			n2 = seq.getLast();
		}
		return seq;
	}

	public static List<Long> fibonacciMaxTerm(long max) {
		LinkedList<Long> seq = new LinkedList<Long>();
		if (max <= 0) {
			return seq;
		}
		seq.add(1l);
		if (max <= 1) {
			return seq;
		}
		seq.add(2l);

		long n1 = 1;
		long n2 = 2;
		long val;
		for (;;) {
			val = n1 + n2;
			if (val > max) {
				break;
			}
			seq.add(val);
			n1 = n2;
			n2 = seq.getLast();
		}
		return seq;
	}

	public static List<Long> collatz(long n) {
		LinkedList<Long> seq = new LinkedList<Long>();
		seq.add(n);
		while (n > 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}
			seq.add(n);
		}
		return seq;
	}

	public static List<String> permutation(String str) {
		List<String> permutations = new LinkedList<String>();
		permutation("", str, permutations);
		return permutations;
	}

	private static void permutation(String prefix, String str, List<String> permutations) {
		int n = str.length();
		if (n == 0) {
			permutations.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n), permutations);
			}
		}
	}

}
