package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 3, 2014
 */
public class Problem004 extends AbstractEulerProblem {

	public Problem004(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int startNumber = 999 * 999;
		int endNumber = 100 * 100;
		while(startNumber >= endNumber) {
			if(MathUtil.isPalindrome(startNumber)) {
				if(hasTwoFactorsOfThreeDigits(startNumber))
					break;
			}
			startNumber--;
		}
	}

	private boolean hasTwoFactorsOfThreeDigits(int palindrome) {
		for(int i = (int) Math.sqrt(palindrome); i > 99; i--) {
			if(palindrome % i == 0 && palindrome / i > 99 & palindrome / i < 1000) {
				setAnswer(i + " " + palindrome / i);
				return true;
			}
		}
		return false;
	}

	@Override
	public String getProblemName() {
		return "Problem 4: Find the largest palindrome made from the product of two 3-digit numbers.";
	}

}
