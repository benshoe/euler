package org.schoen.ben.euler;


/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 5, 2014
 */
public class Opdracht10 implements IEulerProblem {

	@Override
	public void run() {
		long[] primes = PrimeUtil.getPrimes(2000000);
		long sum = 0;
		for(long l : primes) {
			sum += l;
		}
		System.out.println("Total is: " + sum);
	}

	@Override
	public String getProblemName() {
		return "Problem 10: Find the sum of all the primes below two million.";
	}

}
