package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;


/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 5, 2014
 */
public class Problem007 extends AbstractEulerProblem {

	public Problem007(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int count = 1;
		int i = 3;
		while(count != 10000) {
			if(PrimeUtil.isPrime(i += 2))
				count++;
		}
		setAnswer(String.valueOf(i));
	}

	@Override
	public String getProblemName() {
		return "Problem 7: What is the 10 001st prime number?";
	}

}
