package _063;

import main.AbstractProblem;



public class _063 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _063();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int count = 0;
		for(int b = 1; b < 10; b++) {
			for(int p = 1; p < 25; p++) {
				double n = Math.pow(b, p);
				int digits = (int) Math.log10(n) + 1;
				if(p > digits) {
					break;
				}
				if(digits == p) {
					count++;
				}
			}		
		}
		this.answer = count;
	}

}
