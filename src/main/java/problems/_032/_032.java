package problems._032;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

@Solved
public class _032 extends Problem {

	public static void main(String[] args) {
		Problem p = new _032();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		Set<Integer> products = new HashSet<Integer>();
		//  when the a or b is 4 digits the product will be at least 4 digits 
		int min = 123;
		int max = 10000; // isolate min/max based on min digits that a produce a * b will contain
		for (int a = 1; a <= 100; a++) {
			for (int b = min; b < max; b++) {
				if (is1To9PanDigit(a, b)) {
					products.add(a * b);
				}
			}
		}
		this.answer = Numbers.sum(products);
	}

	private boolean is1To9PanDigit(int a, int b) {
		int i = a * b;
		if(i >= 1e8 && i < 1e9) {
			return false;
		}
		BitSet set = new BitSet();
		if (consume(i, set) && consume(a, set) && consume(b, set)) {
			for (int d = 1; d < 10; d++) {
				if (!set.get(d)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean consume(int i, BitSet set) {
		while (i > 0) {
			if (i % 10 == 0) {
				return false;
			}
			if (set.get(i % 10)) {
				return false;
			}
			set.set(i % 10);
			i /= 10;
		}
		return true;
	}
	
}
