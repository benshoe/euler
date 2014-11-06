package org.schoen.ben.euler.util;

import org.junit.*;

public class PrimeUtilTest {

	@Test
	public void testCheckPrime() {
		Assert.assertFalse(PrimeUtil.isPrime(0));
		Assert.assertFalse(PrimeUtil.isPrime(1));
		Assert.assertFalse(PrimeUtil.isPrime(4));
		Assert.assertFalse(PrimeUtil.isPrime(8));
		Assert.assertTrue(PrimeUtil.isPrime(2));
		Assert.assertTrue(PrimeUtil.isPrime(3));
		Assert.assertTrue(PrimeUtil.isPrime(5));
		Assert.assertTrue(PrimeUtil.isPrime(97));
	}
}
