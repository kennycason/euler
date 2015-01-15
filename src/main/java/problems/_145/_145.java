package problems._145;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class _145 extends Problem {

	public static void main(String[] args) {
		Problem p = new _145();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int count = 0;
		for(int i = 1; i < 1000000000; i++) {
			if(i % 10 != 0 && oddDigits(i + Numbers.reverse(i))) {
				// System.out.println(i);
				count++;
			} 
		}
		this.answer = count;
	}
	
	private boolean oddDigits(long n) {
		while(n > 0) {
			if(n % 2 == 0) {
				return false;
			}
			n /= 10;
		}
		return true;
	}
	
}
