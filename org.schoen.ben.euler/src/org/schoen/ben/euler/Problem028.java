package org.schoen.ben.euler;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 29, 2014
 */
public class Problem028 extends AbstractEulerProblem {

	public Problem028(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		long sum = 1;
		int round = 1;
		for(int i = 3; i <= 1001; i += 2) {
			double i2 = Math.pow(i, 2);
			sum += i2;
			sum += i2 - (round * 2);
			sum += i2 - (round * 4);
			sum += i2 - (round * 6);
			round++;
		}
		setAnswer(String.valueOf(sum));
	}

	@Override
	public String getProblemName() {
		return "Problem 28: What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?";
	}

}
