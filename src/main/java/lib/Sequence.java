package lib;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sequence {

    private Sequence() {

    }

    public static long[] fibonacciAsLong(int terms) {
        final long[] sequence = new long[terms];
        if (terms == 0) {
            return sequence;
        }
        sequence[0] = 1;
        if (terms == 1) {
            return sequence;
        }
        sequence[1] = 2;

        long n1 = 1;
        long n2 = 2;
        for (int i = 0; i < terms - 2; i++) {
            sequence[i + 2] = n1 + n2;
            n1 = n2;
            n2 = sequence[i + 2];
        }
        return sequence;
    }

    public static BigInteger[] fibonacci(int terms) {
        final BigInteger[] sequence = new BigInteger[terms];
        if (terms == 0) {
            return sequence;
        }
        sequence[0] = BigInteger.ONE;
        if (terms == 1) {
            return sequence;
        }
        sequence[1] = BigInteger.valueOf(2);

        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.valueOf(2);
        for (int i = 0; i < terms - 2; i++) {
            sequence[i + 2] = n1.add(n2);
            n1 = n2;
            n2 = sequence[i + 2];
        }
        return sequence;
    }

    public static List<Long> fibonacciToMaxTerm(long max) {
        final List<Long> seq = new ArrayList<>();
        if (max <= 0) {
            return seq;
        }
        seq.add(1l);
        if (max <= 1) {
            return seq;
        }
        seq.add(2l);

        long n1 = 1;
        long n2 = 2;
        long val;
        for (;;) {
            val = n1 + n2;
            if (val > max) {
                break;
            }
            seq.add(val);
            n1 = n2;
            n2 = seq.get(seq.size() - 1);
        }
        return seq;
    }

    public static List<Long> collatz(long n) {
        final List<Long> seq = new ArrayList<>();
        seq.add(n);
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            seq.add(n);
        }
        return seq;
    }

    public static Set<String> permutation(String str) {
        Set<String> permutations = new HashSet<String>();
        permutation("", str, permutations);
        return permutations;
    }

    private static void permutation(String prefix, String str, Set<String> permutations) {
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, n), permutations);
            }
        }
    }

    public static Set<Long> permutation(Long n) {
        String str = String.valueOf(n);
        Set<Long> permutations = new HashSet<Long>();
        permutationLongs("", str, permutations);
        return permutations;
    }

    private static void permutationLongs(String prefix, String str, Set<Long> permutations) {
        int n = str.length();
        if (n == 0) {
            permutations.add(Long.parseLong(prefix));
        } else {
            for (int i = 0; i < n; i++) {
                permutationLongs(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1, n), permutations);
            }
        }
    }

}
