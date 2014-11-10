package org.schoen.ben.euler;

import java.math.*;

/**
 * The series, 11 + 22 + 33 + ... + 1010 = 10405071317.
 *
 * Find the last ten digits of the series, 11 + 22 + 33 + ... + 10001000
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 10, 2014
 */
public class Problem048 extends AbstractEulerProblem {

	public Problem048(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		BigInteger answer = new BigInteger("0");
		for(int i = 1; i <= 1000; i++) {
			answer = answer.add(BigInteger.valueOf(i).pow(i));
		}
		System.out.println(answer.toString());
		setAnswer(answer.toString().substring(String.valueOf(answer).length() - 10));
	}

	@Override
	public String getProblemName() {
		return "Problem 48: Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000";
	}

}
