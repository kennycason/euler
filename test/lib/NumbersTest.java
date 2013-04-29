package lib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumbersTest {

	@Test
	public void enumerateTest() {
		long[] numbers = Numbers.enumerate(1, 10);
		assertEquals(10, numbers.length);
		assertEquals(1, numbers[0]);
		assertEquals(10l, numbers[9]);
	}
	
	@Test
	public void is1To9PanDigitTest() {
		assertTrue(Numbers.is1To9PanDigit(123456789));
		assertTrue(Numbers.is1To9PanDigit(123459786));
		assertFalse(Numbers.is1To9PanDigit(12345678));
		assertFalse(Numbers.is1To9PanDigit(1234567890));
		assertFalse(Numbers.is1To9PanDigit(1234566789));
		
		assertTrue(Numbers.is0To9PanDigit(1234567890));
		assertTrue(Numbers.is0To9PanDigit(1234059786));
		assertTrue(Numbers.is0To9PanDigit(123456789)); // invisible preleading 00
		assertFalse(Numbers.is0To9PanDigit(12345678));
		assertFalse(Numbers.is0To9PanDigit(123456789));
		assertFalse(Numbers.is0To9PanDigit(1234566789));
	}

}
