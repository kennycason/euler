package lib;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


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
    }

    @Test
    public void is0To9PanDigitTest() {
		assertTrue(Numbers.is0To9PanDigit(1234567890));
		assertTrue(Numbers.is0To9PanDigit(1234059786));
		assertTrue(Numbers.is0To9PanDigit(123456789)); // invisible preleading 00
		assertFalse(Numbers.is0To9PanDigit(12345678));
		assertTrue(Numbers.is0To9PanDigit(123456789));
		assertFalse(Numbers.is0To9PanDigit(1234566789));
	}

    @Test
    public void getFirstNDigits() {
        assertEquals(2432, Numbers.getFirstNDigits(2432902008176640000L, 4));
        assertEquals(99, Numbers.getFirstNDigits(9999, 2));
    }

    @Test
    public void getLastNDigits() {
        assertEquals(34, Numbers.getLastNDigits(1234, 2));
        assertEquals(234, Numbers.getLastNDigits(1234, 3));
        assertEquals(0, Numbers.getLastNDigits(1234, 0));
        assertEquals(1234, Numbers.getLastNDigits(1234, 4));
    }

    @Test
    public void getNDigit() {
        assertEquals(1, Numbers.getNthDigit(1234, 4));
        assertEquals(2, Numbers.getNthDigit(1234, 3));
        assertEquals(3, Numbers.getNthDigit(1234, 2));
        assertEquals(4, Numbers.getNthDigit(1234, 1));
    }

}
