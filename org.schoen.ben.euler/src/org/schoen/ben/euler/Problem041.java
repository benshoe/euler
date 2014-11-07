package org.schoen.ben.euler;

import java.util.*;

import org.schoen.ben.euler.util.*;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 7, 2014
 */
public class Problem041 extends AbstractEulerProblem {

	public Problem041(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		long answer = 0;
		for(long i = 7654321L; i > 3; i -= 2) { //13456789 and 12345678 are both divisible by 3, so [1,2,3,4,5,6,7] is the only possible pandigit
			if(isUnique(i)) {
				if(PrimeUtil.isPrime(i)) {
					answer = i;
					break;
				}
			}
		}
		setAnswer(String.valueOf(answer));
	}

	private boolean isUnique(long i) {
		String s = String.valueOf(i);
		if(s.contains("0"))
			return false;
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		if(chars[0] - 48 != 1)
			return false;
		for(int j = 0; j < chars.length - 1; j++) {
			if(j + 1 > chars.length)
				return true;
			if(chars[j] + 1 != chars[j + 1])
				return false;
			if(chars[j] == chars[j + 1])
				return false;
		}
		return true;
	}

	@Override
	public String getProblemName() {
		return "Problem 41: What is the largest n-digit pandigital prime that exists?";
	}

}
