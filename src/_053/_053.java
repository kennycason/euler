package _053;

import java.math.BigInteger;

import lib.Probability;




public class _053 {

	public static void main(String[] args) {
		new _053();
	}

	public _053() {
		int total = 0;
		for(int n = 1; n <= 100; n++) {
			for(int k = 0; k <= n; k++) {
				if(Probability.bigCombination(n, k).compareTo(BigInteger.valueOf(1000000)) == 1) {
					total++;
				}
			}
		}
		System.out.println(total);
	}

}
