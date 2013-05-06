package _179;

import lib.Numbers;
import main.AbstractProblem;

public class _179 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _179();
		p.run();
		System.out.println(p.answer());
	}
	
	public _179() {
		solved(false);
	}
	
	public void run() {
		int count = 0;
		int nDiv = Numbers.properDivisors(2).size();
		int n2Div;
		for(int n = 3; n < 10000000 - 1; n++) {
			n2Div = Numbers.properDivisors(n).size();
			if(nDiv == n2Div) {
				count++;
			}
			nDiv = n2Div;
		}
		this.answer = count;
	}
	
}
