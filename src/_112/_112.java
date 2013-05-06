package _112;

import main.AbstractProblem;

public class _112 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _112();
		p.run();
		System.out.println(p.answer());
	}

	/**
	 * when calculating numBouncy / n, it seemed to have precision problems
	 * 
	 * numBouncy / n = x / 100
	 * numBouncy * 100 / n = x
	 */
	public void run() {
//		System.out.println(isBouncy(12344));
//		System.out.println(isBouncy(44321));
//		System.out.println(isBouncy(43251));
		
		int n = 538;
		int numBouncy = n / 2;
		n++;
		for (;;) {
			if(isBouncy(n)) {
				numBouncy++;
			}
			if(n >= 1587000)
			if((numBouncy * 100) % n == 0 && numBouncy * 100 / n == 99) {
				break;
			}
			n++;
			
		}
		this.answer = n;
	}

	private boolean isBouncy(int n) {
		int dir = 0;
		int lastDigit = n % 10;
		// System.out.println(lastDigit + " " + dir);
		n /= 10;
		if (n % 10 < lastDigit) {
			dir = 1;
		} else if (n % 10 > lastDigit) {
			dir = -1;
		}
		lastDigit = n % 10;
		// System.out.println(lastDigit + " " + dir);
		n /= 10;
		while (n > 0) {
			if (n % 10 < lastDigit) {
				if (dir == -1) {
					return true;
				}
				dir = 1;
			} else if (n % 10 > lastDigit) {
				if (dir == 1) {
					return true;
				}
				dir = -1;
			}
			lastDigit = n % 10;
			// System.out.println(lastDigit + " " + dir);
			n /= 10;
		}
		return false;
	}

}
