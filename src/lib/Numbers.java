package lib;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Numbers {

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
		return b == 0 ? a : gcd(b, a % b);
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

	public static List<Long> factors(long n) {
		LinkedList<Long> factors = new LinkedList<Long>();
		for (long i = 2; i < n / i; i++) {
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
	
	public static List<Long> primeFactors(long n) {
		List<Long> factors = new LinkedList<Long>();
		for (long i = 2; i <= n / i; i++) {
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

	public static List<Long> distinctPrimeFactors(long n) {
		return new LinkedList<Long>(new HashSet<Long>(primeFactors(n)));
	}

	public static long[] enumerate(long start, long end) {
		long[] arr = new long[(int) (end - start + 1)];
		int i = 0;
		for (long n = start; i < arr.length; n++, i++) {
			arr[i] = n;
		}
		return arr;
	}
	
	public static List<Long> factorsExclude1AndN(long n) {
		LinkedList<Long> factors = new LinkedList<Long>();
		long half = n / 2;
		for (long i = 2; i <= half; i++) {
			if (n % i == 0) {
				factors.add(i);
			}
		}
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
	
	public static boolean isPalindrome(BigInteger n) {
		return n.toString().equals(new StringBuilder(n.toString()).reverse().toString());
	}
	
	public static BigInteger reverse(BigInteger n) {
		return new BigInteger(new StringBuilder(n.toString()).reverse().toString());
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

	public static boolean isComposite(long n) {
		// prime numbers are natural by definition
		if (n <= 1) {
			return false;
		}
		// is the number divisible by n, such that n >= 2 and n <= sqrt(number)?
		// if so then the number is composite
		double root = Math.sqrt(n);
		for (long i = 2; i <= root; i++) {
			if (n % i == 0) {
				return true;
			}
		}
		return false;
	}

	public static List<Long> primes(long to) {
		List<Long> primes = new LinkedList<Long>();
		for (long i = 2; i <= to; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}

	public static long numCoprimes(int n) {
		long count = 0;
		long[] numbers = Numbers.enumerate(1, n);
		for (int i = 0; i < numbers.length - 1; i++) {
			if (Numbers.gcd(numbers[i], n) == 1) {
				count++;
			}
		}
		return count;
	}

	/*
	 * DynamicAlgorithms.totient(int n) is faster
	 */
	public static long totient(long n) {
		double phin = 1;
		List<Long> primeFactors = distinctPrimeFactors(n);
		for (Long p : primeFactors) {
			phin *= (1.0 - 1.0 / p);
		}
		return (long) Math.round(phin * n);
	}
	
	public static List<Long> coprimes(int to) {
		List<Long> coprimes = new LinkedList<Long>();

		long[] numbers = Numbers.enumerate(1, to);
		for (int i = 0; i < numbers.length - 1; i++) {
			if (Numbers.gcd(numbers[i], to) == 1) {
				coprimes.add(numbers[i]);
			}
		}
		return coprimes;
	}

	public static boolean isPythagoreanTriplet(int a, int b, int c) {
		return a < b && b < c && a * a + b * b == c * c;
	}
	
	public static List<Integer> getDigits(long n) {
		List<Integer> d = new LinkedList<Integer>();
		while (n > 0) {
			d.add((int)(n % 10));
			n /= 10;
		}
		return d;
	}

	public static boolean is1To9PanDigit(int i) {
		if (i < 1e8) {
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
		return true;
	}

	public static boolean is0To9PanDigit(long i) {
		if (i < 1e6) {
			return false;
		}
		BitSet set = new BitSet();
		if (i <= 123456789) { // count for leading zero
			set.set(0);
		}
		while (i > 0) {
			int mod = (int) (i % 10);
			if (set.get(mod)) {
				return false;
			}
			set.set(mod);
			i /= 10;
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
		for (int i = n; i > 0; i--) {
			sb.append(i);
		}
		return Integer.parseInt(sb.toString());
	}

	public static int minPanDigit(int n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			sb.append(i);
		}
		return Integer.parseInt(sb.toString());
	}

}
