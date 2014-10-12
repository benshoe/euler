package org.schoen.ben.euler;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 3, 2014
 */
public class Opdracht4 implements IEulerProblem {

	private String m_answer;

	@Override
	public void run() {
		int startNumber = 999 * 999;
		int endNumber = 100 * 100;
		while(startNumber >= endNumber) {
			if(isPalindrome(startNumber)) {
				if(hasTwoFactorsOfThreeDigits(startNumber))
					break;
			}
			startNumber--;
		}
	}

	private boolean isPalindrome(int startNumber) {
		String palindrome = String.valueOf(startNumber);
		StringBuilder sb = new StringBuilder(palindrome);
		if(palindrome.equals(sb.reverse().toString())) {
			return true;
		}
		return false;
	}

	private boolean hasTwoFactorsOfThreeDigits(int palindrome) {
		for(int i = (int) Math.sqrt(palindrome); i > 99; i--) {
			if(palindrome % i == 0 && palindrome / i > 99 & palindrome / i < 1000) {
				m_answer = i + " " + palindrome / i;
				System.out.println(m_answer);
				return true;
			}
		}
		return false;
	}

	@Override
	public String getProblemName() {
		return "Problem 4: Find the largest palindrome made from the product of two 3-digit numbers.";
	}

	@Override
	public boolean isCorrectAnswer() {
		return "913 993".equals(m_answer);
	}

}
