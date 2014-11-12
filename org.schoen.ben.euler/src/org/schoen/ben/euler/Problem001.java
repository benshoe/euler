package org.schoen.ben.euler;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 12, 2014
 */
public class Problem001 extends AbstractEulerProblem {

	public Problem001(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int sum = 0;
		for(int i = 3; i < 1000; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		setAnswer(String.valueOf(sum));
	}

	@Override
	public String getProblemName() {
		return "Problem 1: Find the sum of all the multiples of 3 or 5 below 1000.";
	}

}
