package org.schoen.ben.euler;

import java.math.*;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/12/15.
 */
public class Problem056 extends AbstractEulerProblem {
	public Problem056(String answer) {
		super(answer);
	}

	@Override public void run() {
		BigInteger answer = BigInteger.ONE;
		for(long a = 1l; a < 100; a++) {
			for(int b = 1; b < 100; b++) {
				BigInteger value = BigInteger.valueOf(a).pow(b);
				BigInteger sumDigits = getSumDigits(value);
				if(sumDigits.compareTo(answer) == 1)
					answer = sumDigits;
			}
		}
		setAnswer(answer.toString());
	}

	private BigInteger getSumDigits(BigInteger value) {
		String digits = value.toString();
		BigInteger sum = BigInteger.ZERO;
		for(int i = 0; i < digits.length(); i++) {
			sum = sum.add(new BigInteger(String.valueOf(digits.charAt(i))));
		}
		return sum;
	}

	@Override public String getProblemName() {
		return "Problem 56: Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?";
	}
}
