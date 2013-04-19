package lib;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Numbers {

	private Numbers() {
	}
	
	public static long sum(List<? extends Number> list) {
		long sum = 0;
		for(Number l : list) {
			sum += l.longValue();
		}
		return sum;
	}
	
	public static List<Long> properDivisors(long n) {
		List<Long> divisors = new LinkedList<Long>();
		for(long i = 1; i <= n / 2; i++) {
			if(n % i == 0) {
				divisors.add(i);
			}
		}
		return divisors;
	}
	
	// poor man's factorial ^_^, should use SplitRecursive or anything but this...
	public static long factorial(long n) {
		long f = 1;
		while(n > 1) {
			f *= n;
			n--;
		}
		return f;
	}
	
	public static BigInteger bigFactorial(long n) {
		BigInteger f = new BigInteger("1");
		while(n > 1) {
			f = f.multiply(new BigInteger(String.valueOf(n)));
			n--;
		}
		return f;
	}	
	
	public static List<Long> primeFactors(long n) {
		LinkedList<Long> factors = new LinkedList<Long>();
		double root = Math.sqrt(n);
		for(long i = 2; i <= root; i++) {
			while(n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if(n > 1) {
			factors.add(n);
		}
		return factors;
	}
	
	public static List<Long> factors(long n) {
		LinkedList<Long> factors = new LinkedList<Long>();
		if(n == 1) {
			factors.add(1l);
			return factors;
		}
		long half = n / 2;
		for(long i = 1; i <= half; i++) {
			if(n % i == 0) {
				factors.add(i);
			}
		}
		factors.add(n);
		return factors;
	}
	
	public static void filterNonPrime(List<Long> list) {
		Iterator<Long> iter = list.iterator();
		while(iter.hasNext()) {
			if(!Numbers.isPrime(iter.next())) {
				iter.remove();
			}
		}
	}
	
	public static BigInteger bigPow(int base, int exp) {
		if(exp == 0) {
			return new BigInteger("0");
		}
		BigInteger n = new BigInteger(String.valueOf(base));
		BigInteger b = new BigInteger(String.valueOf(base));
		for(int i = 1; i < exp; i++) {
			n = n.multiply(b);
		}
		return n;
	}
	
	public static long sum(int from, int to) {
		long sum = 0;
		for(int i = from; i <= to; i++) {
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

	public static boolean isPalindrome(long n) {
		return n == reverse(n);
	}
	
	public static boolean isPrime(long n) {
		// prime numbers are natural by definition
		if(n <= 1) {
			return false;
		}
		// is the number divisible by n, such that n >= 2 and n <= sqrt(number)?
	    // if so then the number is composite
		double root = Math.sqrt(n);
		for(long i = 2; i <= root; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPythagoreanTriplet(int a, int b, int c) {
		return a < b && 
				b < c &&
				a * a + b * b == c * c;
	}

}
