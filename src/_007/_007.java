package _007;

import lib.Numbers;
import main.AbstractProblem;

public class _007 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _007();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int n = 10001;
		
		int found = 0;
		for(int i = 0; ; i++) {
			if(Numbers.isPrime(i)) {
				found++;
				if(found == n) {
					this.answer = i;
					break;
				}
			}
		}
	}
	
}
