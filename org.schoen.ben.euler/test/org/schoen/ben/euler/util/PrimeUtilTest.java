package org.schoen.ben.euler.util;

import org.junit.*;

public class PrimeUtilTest {

	@Test
	public void testCheckPrime() {
		Assert.assertFalse(PrimeUtil.checkPrime(0));
		Assert.assertFalse(PrimeUtil.checkPrime(1));
		Assert.assertTrue(PrimeUtil.checkPrime(2));
		Assert.assertTrue(PrimeUtil.checkPrime(3));
		Assert.assertTrue(PrimeUtil.checkPrime(5));
		Assert.assertTrue(PrimeUtil.checkPrime(97));
	}
}
