package lib;

import java.math.BigInteger;

public class Probability {

	private Probability() {	
	}
	
	/**
	 * (n k) = n! / k!(n - k)!
	 * @param n
	 * @param k
	 * @return
	 */
	public static long combination(long n, long k) {
		return permutation(n, k) / Numbers.factorial(k); // combinations don't care about order, so factor it out
	}
	
	public static BigInteger bigCombination(long n, long k) {
		return bigPermutation(n, k).divide(BigIntegers.factorial(k)); // combinations don't care about order, so factor it out
	}
	
	/**
	 * (n k) = n! / (n - k)!
	 * @param n
	 * @param k
	 * @return
	 */
	public static long permutation(long n, long k) {
		return  Numbers.factorial(n) / Numbers.factorial(n - k);
	}
	
	public static BigInteger bigPermutation(long n, long k) {
		return BigIntegers.factorial(n).divide(BigIntegers.factorial(n - k));
	}
	
}
