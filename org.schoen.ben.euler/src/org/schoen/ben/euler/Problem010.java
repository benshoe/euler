package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;


/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 5, 2014
 */
public class Problem010 extends AbstractEulerProblem {

	public Problem010(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		long sum = 2;
		long i = 3;
		while(i < 2_000_000) {
			if(PrimeUtil.isPrime(i)) {
				sum += i;
			}
			i += 2;
		}
		setAnswer(String.valueOf(sum));
	}

	@Override
	public String getProblemName() {
		return "Problem 10: Find the sum of all the primes below two million.";
	}

}
