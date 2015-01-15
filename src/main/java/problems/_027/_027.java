package problems._027;

import lib.Numbers;
import main.Problem;
import main.annotations.Solved;

@Solved
public class _027 extends Problem {

	public static void main(String[] args) {
		Problem p = new _027();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int maxA = 0;
		int maxB = 0;
		int max = 0;
		int count = 0;
		for(int a = -999; a <= 999; a++) {
			for(int b = -999; b <= 999; b++) {
				count = consecutivePrimes(a, b);
				if(count > max) {
					maxA = a;
					maxB = b;
					max = count;
				}
				
			}	
		}
		this.answer = maxA * maxB;
	}
	
	private int consecutivePrimes(int a, int b) {
		int count = 0;
		for(int n = 0; ; n++) {
			int fnab = n*n + a * n + b;
			if(Numbers.isPrime(fnab)) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

}
