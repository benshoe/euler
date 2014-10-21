package org.schoen.ben.euler.util;

import java.math.*;

public class MathUtil {

	public static BigInteger faculty(BigInteger n) {
		if(n.equals(BigInteger.ONE))
			return BigInteger.ONE;
		return n.multiply(faculty(n.subtract(BigInteger.ONE)));
	}

	public static long faculty(int n) {
		if(n == 1) {
			return 1;
		}
		return n * faculty(n - 1);
	}
}
