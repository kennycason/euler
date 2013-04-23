package lib;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Numbers {

	public static final int[] PRIME_TABLE = { 2, 3, 5, 7, 11, 13, 17, 19, 23,
			29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
			101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163,
			167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233,
			239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311,
			313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389,
			397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463,
			467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563,
			569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641,
			643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727,
			733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821,
			823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907,
			911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997 };

	private Numbers() {
	}

	public static long sum(Collection<? extends Number> list) {
		long sum = 0;
		for (Number l : list) {
			sum += l.longValue();
		}
		return sum;
	}

	public static boolean isDeficient(long n) {
		return sum(properDivisors(n)) < n;
	}

	public static boolean isPerfect(long n) {
		return sum(properDivisors(n)) == n;
	}

	public static boolean isAbundant(long n) {
		return sum(properDivisors(n)) > n;
	}

	public static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a % b); // Not bad for one line of code :)
	}

	public static String asFraction(long a, long b) {
		long gcd = gcd(a, b);
		return (a / gcd) + "/" + (b / gcd);
	}

	public static List<Long> properDivisors(long n) {
		List<Long> divisors = new LinkedList<Long>();
		for (long i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}

	// poor man's factorial ^_^, should use SplitRecursive or anything but
	// this...
	public static long factorial(long n) {
		long f = 1;
		while (n > 1) {
			f *= n;
			n--;
		}
		return f;
	}

	public static BigInteger bigFactorial(long n) {
		BigInteger f = BigInteger.valueOf(1);
		while (n > 1) {
			f = f.multiply(new BigInteger(String.valueOf(n)));
			n--;
		}
		return f;
	}

	public static List<Long> primeFactors(long n) {
		LinkedList<Long> factors = new LinkedList<Long>();
		double root = Math.sqrt(n);
		for (long i = 2; i <= root; i++) {
			while (n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}

	public static List<Long> factors(long n) {
		LinkedList<Long> factors = new LinkedList<Long>();
		if (n == 1) {
			factors.add(1l);
			return factors;
		}
		long half = n / 2;
		for (long i = 1; i <= half; i++) {
			if (n % i == 0) {
				factors.add(i);
			}
		}
		factors.add(n);
		return factors;
	}

	public static void filterNonPrime(List<Long> list) {
		Iterator<Long> iter = list.iterator();
		while (iter.hasNext()) {
			if (!Numbers.isPrime(iter.next())) {
				iter.remove();
			}
		}
	}

	public static BigInteger bigPow(int base, int exp) {
		if (exp == 0) {
			return BigInteger.valueOf(0);
		}
		BigInteger n = BigInteger.valueOf(base);
		BigInteger b = BigInteger.valueOf(base);
		for (int i = 1; i < exp; i++) {
			n = n.multiply(b);
		}
		return n;
	}

	public static long sum(int from, int to) {
		long sum = 0;
		for (int i = from; i <= to; i++) {
			sum += i;
		}
		return sum;
	}

	public static long reverse(long n) {
		long reverse = 0;
		while (n != 0) {
			long lastDigit = n % 10;
			reverse = reverse * 10 + lastDigit;
			n /= 10;
		}
		return reverse;
	}
	
	public static int getNthDigit(long number, int n) {    
		  return (int) ((number / Math.pow(10, n - 1)) % 10);
	}

	public static boolean isPalindrome(long n) {
		return n == reverse(n);
	}

	public static boolean isPrime(long n) {
		// prime numbers are natural by definition
		if (n <= 1) {
			return false;
		}
		// is the number divisible by n, such that n >= 2 and n <= sqrt(number)?
		// if so then the number is composite
		double root = Math.sqrt(n);
		for (long i = 2; i <= root; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static List<Long> primes(int to) {
		List<Long> primes = new LinkedList<Long>();
		for (long i = 2; i <= to; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}

	public static boolean isPythagoreanTriplet(int a, int b, int c) {
		return a < b && b < c && a * a + b * b == c * c;
	}

	public static boolean is1To9PanDigit(int i) {
		if(i < 1e8) { 
			return false;
		}
		BitSet set = new BitSet();
		while (i > 0) {
			int mod = i % 10;
			if (mod == 0 || set.get(mod)) {
				return false;
			}
			set.set(mod);
			i /= 10;
		}
		for (int d = 1; d < 10; d++) {
			if (!set.get(d)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean is0To9PanDigit(long i) {
		if(i < 1e6) {
			return false;
		}
		BitSet set = new BitSet();
		while (i > 0) {
			int mod = (int) (i % 10);
			if (set.get(mod)) {
				return false;
			}
			set.set(mod);
			i /= 10;
		}
		if(i < 1e7) { // count for leading zero
			set.set(0);
		}
		for (int d = 0; d < 10; d++) {
			if (!set.get(d)) {
				return false;
			}
		}
		return true;
	}

	public static boolean is1ToNPanDigit(int i, int n) {
		BitSet set = new BitSet();
		while (i > 0) {
			int mod = i % 10;
			if (mod == 0 || mod > n || set.get(mod)) {
				return false;
			}
			set.set(mod);
			i /= 10;
		}
		return set.cardinality() == n;
	}
	
	public static int maxPanDigit(int n) {
		StringBuffer sb = new StringBuffer();
		for(int i = n; i > 0; i--) {
			sb.append(i);
		}
		return Integer.parseInt(sb.toString());
	}
	
	public static int minPanDigit(int n) {
		StringBuffer sb = new StringBuffer();
		for(int i = 1; i <= n; i++) {
			sb.append(i);
		}
		return Integer.parseInt(sb.toString());
	}
	
}
