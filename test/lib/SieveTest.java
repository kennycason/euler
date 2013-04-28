package lib;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SieveTest {

	@Test
	public void eratosthenesTest() {
		List<Long> primes = Sieve.eratosthenes(120);
		assertEquals(30, primes.size());
		assertEquals(2, (long)primes.get(0));
		assertEquals(3, (long)primes.get(1));
		assertEquals(113, (long)primes.get(29));
	}

}
