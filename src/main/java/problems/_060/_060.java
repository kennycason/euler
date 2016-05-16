package problems._060;

import lib.Numbers;
import lib.Sieve;
import main.Problem;
import main.annotations.Solved;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Solved
public class _060 extends Problem {

    private Set<Long> memoizedPairs = new HashSet<>();

    public static void main(String[] args) {
        Problem p = new _060();
        p.run();
        System.out.println(p.answer());
    }

    public void run() {
        this.answer = smallestSum();
    }

    private long smallestSum() {

        Set<Long> primeSet = new HashSet<Long>();
        List<Long> primePairList = Sieve.eratosthenes(10000);
        Long[] primes = primePairList.toArray(new Long[primePairList.size()]);
        primeSet.addAll(primePairList);


        long smallestSum = Long.MAX_VALUE;
        for(int p1 = 1; p1 < primes.length; p1++) {
            for(int p2 = p1 + 1; p2 < primes.length; p2++) {
                if(!memoizedIsPrime(Numbers.concat(primes[p1], primes[p2]))
                    || !memoizedIsPrime(Numbers.concat(primes[p2], primes[p1]))) {
                     continue;
                }

                for(int p3 = p2 + 1; p3 < primes.length; p3++) {
                    if(!memoizedIsPrime(Numbers.concat(primes[p1], primes[p3]))
                            || !memoizedIsPrime(Numbers.concat(primes[p3], primes[p1]))
                            || !memoizedIsPrime(Numbers.concat(primes[p2], primes[p3]))
                            || !memoizedIsPrime(Numbers.concat(primes[p3], primes[p2]))) {
                        continue;
                    }

                    for(int p4 = p3 + 1; p4 < primes.length; p4++) {
                        if(!memoizedIsPrime(Numbers.concat(primes[p1], primes[p4]))
                                || !memoizedIsPrime(Numbers.concat(primes[p4], primes[p1]))
                                || !memoizedIsPrime(Numbers.concat(primes[p2], primes[p4]))
                                || !memoizedIsPrime(Numbers.concat(primes[p4], primes[p2]))
                                || !memoizedIsPrime(Numbers.concat(primes[p3], primes[p4]))
                                || !memoizedIsPrime(Numbers.concat(primes[p4], primes[p3]))) {
                            continue;
                        }

                        for(int p5 = p4 + 1; p5 < primes.length; p5++) {
                            if(!memoizedIsPrime(Numbers.concat(primes[p1], primes[p5]))
                                    || !memoizedIsPrime(Numbers.concat(primes[p5], primes[p1]))
                                    || !memoizedIsPrime(Numbers.concat(primes[p2], primes[p5]))
                                    || !memoizedIsPrime(Numbers.concat(primes[p5], primes[p2]))
                                    || !memoizedIsPrime(Numbers.concat(primes[p3], primes[p5]))
                                    || !memoizedIsPrime(Numbers.concat(primes[p5], primes[p3]))
                                    || !memoizedIsPrime(Numbers.concat(primes[p4], primes[p5]))
                                    || !memoizedIsPrime(Numbers.concat(primes[p5], primes[p4]))) {
                                continue;
                            }

                            // all prime
                            long sum = primes[p1] + primes[p2] + primes[p3] + primes[p4] + primes[p5];
                            if(sum < smallestSum) {
                                //System.out.println(primes[p1] + " " + primes[p2] + " " + primes[p3] + " " + primes[p4] + " " + primes[p5]);
                                System.out.println("Smallest Sum: " + sum);
                                smallestSum = sum;
                            }
                        }
                    }
                }
            }
        }
        return smallestSum;
    }

    public boolean memoizedIsPrime(long n) {
        if(memoizedPairs.contains(n)) {
            return true;
        }
        if(Numbers.isPrime(n)) {
            memoizedPairs.add(n);
            return true;
        }
        return false;
    }


}
