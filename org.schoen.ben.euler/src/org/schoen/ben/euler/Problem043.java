package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
 *
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 *
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 *
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 8, 2014
 */
public class Problem043 extends AbstractEulerProblem {

	public Problem043(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		long answer = 0L;
		String[] values = PermutationUtil.getPermutations("0123456789");
		for(String s : values) {
			if(s.charAt(0) == '0')
				continue;
			int d4 = s.charAt(3) - 48;
			if(d4 % 2 != 0)
				continue;

			int d6 = s.charAt(5) - 48;
			if(d6 == '5' || d6 == '0')
				continue;

			if(!divisorCorrect(s.substring(7, 10), 17))
				continue;
			if(!divisorCorrect(s.substring(6, 9), 13))
				continue;
			if(!divisorCorrect(s.substring(5, 8), 11))
				continue;
			if(!divisorCorrect(s.substring(4, 7), 7))
				continue;
			if(!divisorCorrect(s.substring(3, 6), 5))
				continue;
			if(!divisorCorrect(s.substring(2, 5), 3))
				continue;
			answer += new Long(s).longValue();
		}
		setAnswer(String.valueOf(answer));
	}

	private boolean divisorCorrect(String substring, int i) {
		int value = new Integer(substring).intValue();
		return value % i == 0;
	}

	@Override
	public String getProblemName() {
		return "Problem 43: Find the sum of all 0 to 9 pandigital numbers with this property.";
	}

}
