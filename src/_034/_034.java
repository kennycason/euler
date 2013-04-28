package _034;

import lib.Numbers;
import main.AbstractProblem;


public class _034 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _034();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int sum = 0;
		for(int i = 3; i < 100000; i++) {
			if(digitsFactorialSum(i) == i) {
				sum += i;
			}
		}
		this.answer = sum;
	}

	private long digitsFactorialSum(int i) {
		long sum = 0;
		while(i > 0) {
			sum += Numbers.factorial(i % 10);
			i /= 10;
		}
		return sum;
	}
	
	

}
