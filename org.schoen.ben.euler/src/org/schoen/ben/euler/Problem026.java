package org.schoen.ben.euler;

import java.math.*;

import org.schoen.ben.euler.util.*;

/**
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 25, 2014
 */
public class Problem026 extends AbstractEulerProblem {

	public Problem026(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		MathContext MATH_CTX = new MathContext(2000, RoundingMode.HALF_UP);
		int patternLength = 0;
		int answer = 0;
		BigDecimal value = BigDecimal.ONE;
		for(int i = 7; i < 1000; i += 2) {
			if(!PrimeUtil.checkPrime(i)) {
				continue;
			}
			value = BigDecimal.ONE.divide(new BigDecimal(i), MATH_CTX).multiply(BigDecimal.TEN.pow(String.valueOf(i).length() - 1));
			int valuePatternLength = getPatternLength(value.toString());
			if(valuePatternLength > patternLength) {
				patternLength = valuePatternLength;
				answer = i;
			}
		}
		setAnswer(String.valueOf(answer));
	}

	private int getPatternLength(String value) {
		String decimals = value.substring(2);
		StringBuilder pattern = new StringBuilder();
		String firstChar = decimals.substring(0, 1);
		int i = 0;
		int posNext = 0;
		String decimal = "";
		while(!firstChar.equals(decimal) && decimals.length() > i) {
			posNext = decimals.indexOf(firstChar, 1);
			String possiblePattern = decimals.substring(i, posNext);
			String nextPattern = decimals.substring(posNext, posNext + possiblePattern.length());
			if(possiblePattern.equals(nextPattern))
				return possiblePattern.length();
			firstChar = possiblePattern;

		}
		return pattern.length();
	}

	@Override
	public String getProblemName() {
		return "Problem 26: Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.";
	}

}
