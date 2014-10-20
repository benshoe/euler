package org.schoen.ben.euler;

import java.math.*;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 18, 2014
 */
public class Problem020 extends AbstractEulerProblem {

	public Problem020(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		BigInteger fac100 = calculateFaculty(new BigInteger("100"));
		String faculty100 = fac100.toString();
		int sum = 0;
		for(int i = 0; i < fac100.toString().length(); i++) {
			sum += Integer.valueOf(faculty100.substring(i, i + 1)).intValue();
		}
		setAnswer(String.valueOf(sum));
	}

	private BigInteger calculateFaculty(BigInteger n) {
		if(n.equals(BigInteger.ONE))
			return BigInteger.ONE;
		return n.multiply(calculateFaculty(n.subtract(BigInteger.ONE)));
	}

	@Override
	public String getProblemName() {
		return "Problem 20: Find the sum of the digits in the number 100!";
	}

}
