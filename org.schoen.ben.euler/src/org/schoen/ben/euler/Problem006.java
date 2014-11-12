package org.schoen.ben.euler;

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 12, 2014
 */
public class Problem006 extends AbstractEulerProblem {

	public Problem006(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int sum = 0;
		long sqr = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
			sqr += Math.pow(i, 2);
		}
		long answer = (long) (Math.pow(sum, 2) - sqr);
		setAnswer(String.valueOf(answer));
	}

	@Override
	public String getProblemName() {
		return "Problem 6: Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.";
	}

}
