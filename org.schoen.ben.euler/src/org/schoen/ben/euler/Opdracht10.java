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
		long sum = 2;
		long i = 3;
		while(i < 2000000) {
			if(PrimeUtil.checkPrime(i)) {
				sum += i;
			}
			i += 2;
		}
		System.out.println("Total is: " + sum);
	}

	@Override
	public String getProblemName() {
		return "Problem 10: Find the sum of all the primes below two million.";
	}

}
