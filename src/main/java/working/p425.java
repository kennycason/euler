package working;

import lib.Numbers;
import main.Problem;

import java.util.*;

// ugh redo using a graph traversal solution (try djikstra's)
public class p425 extends Problem {

    public static void main(String[] args) {
        Problem p = new p425();
        p.run();
        System.out.println(p.answer());
    }

//    System.out.println(" > " + isTwosRelative(2, 11, connectedPrimes, new HashSet<Integer>()));
//    System.out.println(" > " + isTwosRelative(2, 103, connectedPrimes, new HashSet<Integer>()));
    public void run() {
        final int n = 10_000_000;
        // generating primes
        final List<Long> primes = Numbers.primes(n + 1_000);
        System.out.println("generated primes");
        int sumNoChain = 0;
        // generate all chains
        final Map<Integer, Set<Integer>> connectedPrimes = new HashMap<>();
        for (int i = 0; primes.get(i) <= n; i++) {
            final int prime_i = (int) (long) primes.get(i);
            final Set<Integer> connected = new HashSet<>();
            for (int j = 0; primes.get(j) <= n; j++) {
                final int prime_j = (int) (long) primes.get(j);
                if (prime_i == prime_j) { continue; }
                if (!withinOnePower(prime_i, prime_j)) { continue; }

                // is 2s relative check
                if (isConnected(prime_i, prime_j)) {
                    // System.out.println(prime.p + " <-> " + Primes.PRIME_TABLE[j]);
                    connected.add(prime_j);
                }
            }
            connectedPrimes.put(prime_i, connected);
        }
        System.out.println("generated tree");
        // traverse chains for path to P
        for (int i = 0; primes.get(i) <= n; i++) {
            final int prime_i = (int) (long) primes.get(i);
            if (!isTwosRelative(2, prime_i, connectedPrimes, new HashSet<Integer>())) {
                // System.out.println(Primes.PRIME_TABLE[i] + " is NOT 2's relative");
                sumNoChain += primes.get(i);
            }
        }
        answer = sumNoChain - 2; // un-count 2
    }

    private static boolean isTwosRelative(final int root, final int target, final Map<Integer, Set<Integer>> connectedPrimes, final Set<Integer> visited) {
        if (!connectedPrimes.containsKey(target)) { throw new IllegalStateException("Unknown prime accounted for: " + target); }
        if (visited.contains(root)) { return false; }

        if (connectedPrimes.get(root).contains(target)) {
          //  System.out.println("matched: " + root + " -> " + target);
            return true;
        }

        visited.add(root);
        for (final int connected : connectedPrimes.get(root)) {
            if (visited.contains(connected)) { continue; }
            if (connected > target) { continue; }
            if (isTwosRelative(connected, target, connectedPrimes, visited)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isConnected(final int a, final int b) {
        return isSameLengthAndDifferentByOneDigit(a, b) || addDigitLeftIsSame(a, b);
    }

    private static boolean addDigitLeftIsSame(final int a, final int b) {
        return b == trimLeftDigit(a) || trimLeftDigit(b) == a;
    }

    private static int trimLeftDigit(int n) {
        return n % (int) Math.pow(10, (int) Math.log10(n));
    }

    private static boolean withinOnePower(final int a, final int b) {
        return Math.abs((int) Math.log10(a) - (int) Math.log10(b)) <= 1;
    }

    private static boolean isSameLengthAndDifferentByOneDigit(int a, int b) {
        int digitsDifferent = 0;
        for (;;) {
            if (a <= 0 || b <= 0) { break; }

            if (a % 10 != b % 10) {
                digitsDifferent++;
                if (digitsDifferent > 1) { return false; }
            }
            a /= 10;
            b /= 10;
        }
        return digitsDifferent == 1 && a == 0 && b == 0;
    }

    private void test() {
        // isSameLengthAndDifferentByOneDigit
        System.out.println(isSameLengthAndDifferentByOneDigit(123, 173));
        System.out.println(isSameLengthAndDifferentByOneDigit(2, 5));
        System.out.println(isSameLengthAndDifferentByOneDigit(124, 173));
        System.out.println(isSameLengthAndDifferentByOneDigit(12, 123));
        // trimLeftDigit
        System.out.println(trimLeftDigit(123));
        // addDigitLeftIsSame
        System.out.println(addDigitLeftIsSame(123, 23));
        System.out.println(addDigitLeftIsSame(23, 123));
        System.out.println(addDigitLeftIsSame(123, 24));
    }

}
