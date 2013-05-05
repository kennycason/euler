package _069;

import lib.DynamicAlgorithms;
import main.AbstractProblem;

public class _069 extends AbstractProblem {

	public static void main(String[] args) {
		AbstractProblem p = new _069();
		p.run();
		System.out.println(p.answer());
	}


	public void run() {
		int upper = 1000000;
		double maxRatio = 0;
		int maxN = -1;
		long[] totients = DynamicAlgorithms.totientSums(upper);
		for(int n = 2; n < upper; n++) {
			double ratio = (double)n / totients[n];
			if(ratio >= maxRatio) {
				maxRatio = ratio;
				maxN = n;
			}
		}
		this.answer = maxN;
	}
	
}
