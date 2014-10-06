package org.schoen.ben.euler;

import java.math.*;
import java.util.*;

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
		List<BigInteger> primes = PrimeUtil.getPrimesUpUntil(200000l);
		long sum = 0;
		for(BigInteger prime : primes) {
			sum += prime.longValue();
		}
		System.out.println();
		System.out.println(sum);
	}

	@Override
	public String getProblemName() {
		return "Problem 10: Find the sum of all the primes below two million.";
	}

}
