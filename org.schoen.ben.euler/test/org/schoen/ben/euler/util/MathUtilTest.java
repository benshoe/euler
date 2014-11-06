package org.schoen.ben.euler.util;

import org.junit.*;

public class MathUtilTest {

	@Test
	public void testIsPalindromeLong() {
		Assert.assertTrue(MathUtil.isPalindrome(0));
		Assert.assertTrue(MathUtil.isPalindrome(12321));
		Assert.assertTrue(MathUtil.isPalindrome(11));
		Assert.assertTrue(MathUtil.isPalindrome(191));
	}

	@Test
	public void testIsPalindromeString() {
		Assert.assertTrue(MathUtil.isPalindrome(""));
		Assert.assertTrue(MathUtil.isPalindrome("1"));
		Assert.assertTrue(MathUtil.isPalindrome("1234321"));
	}

}
