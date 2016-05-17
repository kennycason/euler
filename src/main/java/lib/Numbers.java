package lib;

import java.util.*;

public class Numbers {

    private Numbers() {
    }

    public static long sum(final Iterable<? extends Number> list) {
        long sum = 0;
        for (final Number l : list) {
            sum += l.longValue();
        }
        return sum;
    }

    public static long sum(final int... is) {
        long sum = 0;
        for (final Number l : is) {
            sum += l.longValue();
        }
        return sum;
    }

    public static long sumDigits(final String n) {
        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Character.getNumericValue(n.charAt(i));
        }
        return sum;
    }

    public static boolean isDeficient(final long n) {
        return sum(properDivisors(n)) < n;
    }

    public static boolean isPerfect(final long n) {
        return sum(properDivisors(n)) == n;
    }

    public static boolean isAbundant(final long n) {
        return sum(properDivisors(n)) > n;
    }

    public static long gcd(final long a, final long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long gcd(final long a, final long b, final long c) {
        return gcd(a, gcd(b, c));
    }

    public static String asFraction(final long a, final long b) {
        final long gcd = gcd(a, b);
        return (a / gcd) + "/" + (b / gcd);
    }

    public static List<Long> properDivisors(final long n) {
        final List<Long> divisors = new ArrayList<>();
        for (long i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    public static List<Long> positiveDivisors(final long n) {
        final List<Long> divisors = new ArrayList<>();
        for (long i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        divisors.add(n);
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

    public static boolean isPowerOfTwo(int n) {
        boolean isPowerOfTwo = true;
        int reminder = 0;
        while (n > 1) {
            reminder = n % 2;
            if (reminder != 0) {
                isPowerOfTwo = false;
                break;
            } else {
                n = n / 2;
            }
        }
        return isPowerOfTwo;
    }

    public static List<Long> factors(long n) {
        final List<Long> factors = new ArrayList<>();
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
        final List<Long> factors = new ArrayList<>();
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

    public static List<Long> distinctPrimeFactors(final long n) {
        return new ArrayList<>(new HashSet<>(primeFactors(n)));
    }

    public static long[] enumerate(final long start, final long end, final int step) {
        final long[] arr = new long[(int) (end - start + 1) / step];
        int i = 0;
        for (long n = start; i < arr.length; n += step, i++) {
            arr[i] = n;
        }
        return arr;
    }

    public static long[] enumerate(final long start, final long end) {
        return enumerate(start, end, 1);
    }

    public static List<Long> factorsExclude1AndN(final long n) {
        final List<Long> factors = new ArrayList<>();
        final long half = n / 2;
        for (long i = 2; i <= half; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    public static void filterNonPrime(final List<Long> list) {
        final Iterator<Long> iter = list.iterator();
        while (iter.hasNext()) {
            if (!isPrime(iter.next())) {
                iter.remove();
            }
        }
    }

    public static long sum(final int from, final int to) {
        long sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i;
        }
        return sum;
    }

    public static long reverse(long n) {
        long reverse = 0;
        while (n != 0) {
            final long lastDigit = n % 10;
            reverse = reverse * 10 + lastDigit;
            n /= 10;
        }
        return reverse;
    }

    public static int[] getDigits(long n) {
        final int digits = numDigits(n);
        final int[] d = new int[digits];
        int i = 0;
        while (n > 0) {
            d[i] = (int)(n % 10);
            n /= 10;
            i++;
        }
        return d;
    }

    public static int numDigits(final long n) {
        return (int) Math.log10(n) + 1;
    }

    public static int getNthDigit(final long number, final int n) {
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }

    public static long getFirstNDigits(long number, final int n) {
        final long max = (long) Math.pow(10, n) - 1;
        while(number > max) {
            number /= 10;
        }
        return number;
    }

    public static long getLastNDigits(final long number, final int n) {
        return number % (int) Math.pow(10, n);
    }

    public static long concat(long n, final long n2) {
        long c = n2;
        while (c > 0) {
            n *= 10;
            c /= 10;
        }
        return n + n2;
    }

    public static boolean isPalindrome(final long n) {
        return n == reverse(n);
    }

    public static boolean isPrime(final long n) {
        // prime numbers are natural by definition
        if (n <= 1) {
            return false;
        }
        // is the number divisible by n, such that n >= 2 and n <= sqrt(number)?
        // if so then the number is composite
        final double root = Math.sqrt(n);
        for (long i = 2; i <= root; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isComposite(final long n) {
        // prime numbers are natural by definition
        if (n <= 1) {
            return false;
        }
        // is the number divisible by n, such that n >= 2 and n <= sqrt(number)?
        // if so then the number is composite
        final double root = Math.sqrt(n);
        for (long i = 2; i <= root; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }

    public static List<Long> primes(final long to) {
        final List<Long> primes = new ArrayList<>();
        for (long i = 2; i <= to; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static long numCoprimes(final int n) {
        long count = 0;
        final long[] numbers = Numbers.enumerate(1, n);
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
    public static long totient(final long n) {
        double phin = 1;
        final List<Long> primeFactors = distinctPrimeFactors(n);
        for (final Long p : primeFactors) {
            phin *= (1.0 - 1.0 / p);
        }
        return Math.round(phin * n);
    }

    public static List<Long> coprimes(final int to) {
        final List<Long> coprimes = new ArrayList<>();

        final long[] numbers = Numbers.enumerate(1, to);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (Numbers.gcd(numbers[i], to) == 1) {
                coprimes.add(numbers[i]);
            }
        }
        return coprimes;
    }

    public static boolean isPythagoreanTriplet(final int a, final int b, final int c) {
        return a < b && b < c && a * a + b * b == c * c;
    }

    public static boolean is1To9PanDigit(int i) {
        if (i < 1e8) {
            return false;
        }
        final BitSet set = new BitSet();
        while (i > 0) {
            final int mod = i % 10;
            if (mod == 0 || set.get(mod)) {
                return false;
            }
            set.set(mod);
            i /= 10;
        }
        return true;
    }

    public static boolean is0To9PanDigit(int i) {
        if (i < 123456789) {
            return false;
        }
        final BitSet set = new BitSet();
        if (i <= 123456789) { // count for leading zero
            set.set(0);
        }
        while (i > 0) {
            final int mod = i % 10;
            if (set.get(mod)) {
                return false;
            }
            set.set(mod);
            i /= 10;
        }
        return true;
    }

    public static boolean is1ToNPanDigit(int i, final int n) {
        final BitSet set = new BitSet();
        while (i > 0) {
            final int mod = i % 10;
            if (mod == 0 || mod > n || set.get(mod)) {
                return false;
            }
            set.set(mod);
            i /= 10;
        }
        return set.cardinality() == n;
    }

    public static int maxPanDigit(final int n) {
        final StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    public static int minPanDigit(final int n) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    public static int intPower(final int b, final int e) {
        int power = b;
        for(int i = 0; i < e - 1; i++) {
            power *= b;
        }
        return power;
    }

    public String join(final int[] digits) {
        final StringBuilder stringBuilder = new StringBuilder();
        for(final int d : digits) {
            stringBuilder.append(d);
        }
        return stringBuilder.toString();
    }

}
