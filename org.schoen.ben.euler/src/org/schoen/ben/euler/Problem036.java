package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

/**
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 6, 2014
 */
public class Problem036 extends AbstractEulerProblem {

	public Problem036(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		/*
		 * Only uneven numbers can be palindromic since they end in a 1 (binary)
		 * and the base may not include leading zeros.
		 */
		int answer = 0;
		for(int i = 1; i < 1000000; i += 2) {
			if(MathUtil.isPalindrome(i)) {
				if(MathUtil.isPalindrome(Integer.toBinaryString(i))) {
					System.out.println(i + "/" + Integer.toBinaryString(i));
					answer += i;
				}
			}
		}
		setAnswer(String.valueOf(answer));
	}

	@Override
	public String getProblemName() {
		return "Problem 36: Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.";
	}

}
