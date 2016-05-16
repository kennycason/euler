package lib;

import org.junit.Test;

import java.util.LinkedList;

public class PrimeCalculationTest {

    @Test
    public void test() {
        LinkedList<Long[]> times = new LinkedList<Long[]>();
        System.out.println("Sieve\tIterate all");
        for(int i = 1; i < 7; i++) {
            times.add(test((int)Math.pow(10, i)));
            System.out.println(times.getLast()[0] + "ms\t" + times.getLast()[1] + "ms");
        }

    }

    private Long[] test(int to) {
        Long[] t = new Long[2];
        Clock clock = Clock.getInstance();
        System.out.println("primes to: " + to);
        clock.start();
        Sieve.eratosthenes(to);
        t[0] = clock.elapsedMillis();

        clock.reset();
        Numbers.primes(to);
        t[1] = clock.elapsedMillis();
        return t;
    }

}
