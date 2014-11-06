package org.schoen.ben.euler.util;

import java.math.*;

public class MathUtil {

	public static BigInteger faculty(BigInteger n) {
		if(n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		return n.multiply(faculty(n.subtract(BigInteger.ONE)));
	}

	public static long faculty(long n) {
		if(n == 1) {
			return 1;
		}
		return n * faculty(n - 1);
	}

	public static boolean isPalindrome(long startNumber) {
		String palindrome = String.valueOf(startNumber);
		return isPalindrome(palindrome);
	}

	public static boolean isPalindrome(String s) {
		return s.equals(new StringBuilder(s).reverse().toString());
	}
}
