package _072;

import lib.Numbers;




public class _072 {

	public static void main(String[] args) {
		new _072();
	}

	/**
	 * refer to notes.txt
	 */
	public _072() {
		int n = 1000000;
		long count = 0;
//		for(int i = 2; i <= n; i++) {
//			// count += Numbers.numCoprimes(i);	// 1st method, very slow
//			count += Numbers.totient(i); // 2nd method, fast,
//		}
		/*
		 * fastest way
		 * use dynamic programming since the sum(n* prod(1 - 1/p)) is 
		 * summed up over and over with many repeating values
		 */
		long[] phi = Numbers.enumerate(0, n + 1);
		for(int i = 2; i <= n; i++){
		    if (phi[i] == i) {
		        for (int j = i; j <= n; j += i) {
		            phi[j] = phi[j] / i * (i - 1);
		        }
		    }
		    count += phi[i];
		}
		System.out.println(count);
	}
	
}
