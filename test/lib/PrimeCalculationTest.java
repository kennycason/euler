package lib;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class PrimeCalculationTest {

	@Test
	public void test() {

		List<Long[]> times = new LinkedList<Long[]>();
		for(int i = 1; i < 10; i++) {
			times.add(test((int)Math.pow(10, i)));
		}
	}
	
	private Long[] test(int to) {
		Long[] t = new Long[2];
		Clock clock = Clock.getInstance();
		System.out.println(to + " test");
		clock.start();
		Sieve.eratosthenes(to);
		t[0] = clock.elapsedMillis();
		
		clock.reset();
		Numbers.primes(to);
		t[1] = clock.elapsedMillis();
		return t;
	}

}
