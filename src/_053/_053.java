package _053;

import java.math.BigInteger;

import lib.Probability;
import main.AbstractProblem;




public class _053 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _053();
		p.run();
		System.out.println(p.answer());
	}

	public void run() {
		int total = 0;
		for(int n = 1; n <= 100; n++) {
			for(int k = 0; k <= n; k++) {
				if(Probability.bigCombination(n, k).compareTo(BigInteger.valueOf(1000000)) == 1) {
					total++;
				}
			}
		}
		this.answer = total;
	}

}
