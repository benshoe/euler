package org.schoen.ben.euler;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 3, 2014
 */
public class Problem005 extends AbstractEulerProblem {

	public Problem005(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		boolean found = false;
		int number = 0;
		while(!found) {
			number++;
			if(isDeelbaarDoor1tot20(number)) {
				found = true;
			}
		}
		setAnswer(String.valueOf(number));
	}

	private boolean isDeelbaarDoor1tot20(int number) {
		for(int i = 1; i <= 20; i++) {
			if(number % i != 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String getProblemName() {
		return "Problem 5: What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?";
	}

}
