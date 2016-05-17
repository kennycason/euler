package working;

import lib.Clock;
import lib.Sequence;
import main.Problem;

import java.math.BigInteger;


public class p297 extends Problem {

    private static BigInteger[] fibonacci = Sequence.fibonacci(100000);
    private static long[] fibonacciL = Sequence.fibonacciAsLong(100000);

    public static void main(String[] args) {
        Problem p = new p297();
        p.run();
        System.out.println(p.answer());
    }

    /*
    Each new term in the Fibonacci sequence is generated by adding the previous two terms.
    Starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89.

    Every positive integer can be uniquely written as a sum of nonconsecutive terms of the Fibonacci sequence. For example, 100 = 3 + 8 + 89.
    Such a sum is called the Zeckendorf representation of the number.

    For any integer n>0, let z(n) be the number of terms in the Zeckendorf representation of n.
    Thus, z(5) = 1, z(14) = 2, z(100) = 3 etc.
    Also, for 0<n<10^6, ∑ z(n) = 7894453.

    Find ∑ z(n) for 0<n<10^17.


    NOTES
    There are other ways of representing 100 as the sum of Fibonacci numbers – for example

    100 = 89 + 8 + 2 + 1
    100 = 55 + 34 + 8 + 3
    but these are not Zeckendorf representations because 1 and 2 are consecutive Fibonacci numbers, as are 34 and 55.

    For any given positive integer, a representation that satisfies the conditions of Zeckendorf's theorem can be found by using a greedy algorithm, choosing the largest possible Fibonacci number at each stage.
     */
    public void run() {
        bruteForce2();
    }
    public void bruteForce2() {
        Clock clock = Clock.getInstance();
        clock.start();
        long numbers = 0;
        int startIndex = 0;
        long max = 100_000_000_000L; //100_000_000_000_000_000L;
        for(long i = 1; i < max; i++) {
            while(fibonacciL[startIndex] <= i) {
                startIndex++;
            }

            long currentSum = 0;
            int subNumbers = 0;
            for(int j = startIndex; j >= 0; j--) {
                final long addedValue = currentSum + fibonacciL[j];
                if(addedValue <= i) {
                    currentSum = addedValue;
                    subNumbers++;
                }
                if(currentSum == i) {
                    numbers += subNumbers;
                    break;
                }
            }
        }
        this.answer = numbers;
        System.out.println("e: " + clock.elapsedMillis() + "ms");
    }

    // print out sequences
    public void bruteForce() {
        Clock clock = Clock.getInstance();
        clock.start();
        long numbers = 0;
        int startIndex = 0;
        long max = 1000000; //100_000_000_000_000_000L;
        for(long i = 1; i < max; i++) {
            System.out.print(i + ":\t");
            while(fibonacci[startIndex].compareTo(BigInteger.valueOf(i)) <= 0) {
                startIndex++;
            }

            final BigInteger targetSum = BigInteger.valueOf(i);
            BigInteger currentSum = BigInteger.ZERO;
            int subNumbers = 0;
            for(int j = startIndex; j >= 0; j--) {
                final BigInteger addedValue = currentSum.add(fibonacci[j]);
                if(addedValue.compareTo(targetSum) <= 0) {
                    currentSum = addedValue;
                    subNumbers++;
                    System.out.print(fibonacci[j] + "\t");
                }
                if(currentSum.equals(targetSum)) {
                    numbers += subNumbers;
                    break;
                }
            }
            System.out.println();
        }
        this.answer = numbers;
        System.out.println("e: " + clock.elapsedMillis() + "ms");
    }

}