package org.schoen.ben.euler;

import java.math.*;

import org.schoen.ben.euler.util.*;


/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 3, 2014
 */
public class Problem034 extends AbstractEulerProblem {

	public Problem034(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		long answer = 0;
		for(long i = MathUtil.faculty(9); i > 2; i--) { //MathUtil.faculty(9)
			BigInteger sum = BigInteger.ZERO;
			String factorial = String.valueOf(i);
			for(int j = 0; j < factorial.length(); j++) {
				BigInteger fact = new BigInteger(String.valueOf(factorial.charAt(j) - 48));
				sum = sum.add(MathUtil.faculty(fact));
			}
			if(sum.longValue() == i) {
				answer += sum.longValue();
				System.out.println(sum.longValue() + ": " + i);
			}
		}
		setAnswer(String.valueOf(answer));
	}

	@Override
	public String getProblemName() {
		return "Problem 34: Find the sum of all numbers which are equal to the sum of the factorial of their digits.";
	}

}
