package org.schoen.ben.euler;


public class Problem012 extends AbstractEulerProblem {

	public Problem012(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		long number = 1;
		long next = 2;
		for(;;) {
			long answer = calculateFactors(number, 500);
			if(answer != -1) {
				setAnswer(String.valueOf(answer));
				break;
			}
			number += next;
			next++;
		}
	}

	private long calculateFactors(long number, int factors) {
		int count = 0;
		for(long i = 1; i <= Math.sqrt(number); i++) {
			if(number % i == 0) {
				if(number == i) {
					count++;
				} else {
					count += 2;
				}
			}
		}
		if(count >= factors)
			return number;
		return -1;
	}

	@Override
	public String getProblemName() {
		return "Problem 12: What is the value of the first triangle number to have over five hundred divisors?";
	}

}
