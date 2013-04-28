package _001;

import main.AbstractProblem;

public class _001 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _001();
		p.run();
		System.out.println(p.answer());
	}
	
	public void run() {
		
		int max = 1000;
		
		int sum = 0;
		for(int i = 1; i < max; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		this.answer = sum;
	}
	
}
