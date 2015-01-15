package lib;

import java.math.BigInteger;

/**
 * Created by kenny on 1/14/15.
 */
public class BigIntegers {

    public static BigInteger factorial(long n) {
        BigInteger f = BigInteger.valueOf(1);
        while (n > 1) {
            f = f.multiply(new BigInteger(String.valueOf(n)));
            n--;
        }
        return f;
    }

    public static BigInteger pow(int base, int exp) {
        if(base == 2) {
            return pow2(exp);
        }
        if (exp == 0) {
            return BigInteger.valueOf(0);
        }
        BigInteger n = BigInteger.valueOf(base);
        BigInteger b = BigInteger.valueOf(base);
        for (int i = 1; i < exp; i++) {
            n = n.multiply(b);
        }
        return n;
    }

    public static BigInteger pow2(int exp) {
        // for really large exp should do something like: http://stackoverflow.com/questions/4102010/calculating-extremely-large-powers-of-2
        return BigInteger.ONE.shiftLeft(exp);
    }

    public static boolean isPalindrome(BigInteger n) {
        return n.toString().equals(new StringBuilder(n.toString()).reverse().toString());
    }

    public static BigInteger reverse(BigInteger n) {
        return new BigInteger(new StringBuilder(n.toString()).reverse().toString());
    }

    public static BigInteger getLastNDigits(BigInteger number, int n) {
        return number.mod(BigInteger.valueOf((int) Math.pow(10, n)));
    }

}
