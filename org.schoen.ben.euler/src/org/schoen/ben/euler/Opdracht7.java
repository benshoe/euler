package org.schoen.ben.euler;

import java.math.*;
import java.util.*;


/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 5, 2014
 */
public class Opdracht7 implements IEulerProblem {

	@Override
	public void run() {

		List<BigInteger> primes = PrimeUtil.getPrimesUpUntil(110000l);
		System.out.println();
		System.out.println("Number of primes found: " + primes.size());
		for(int i = 9998; i < 10004; i++) {
			System.out.println("Prime " + i + ": " + primes.get(i));
		}
	}

	@Override
	public String getProblemName() {
		return "Problem 7: What is the 10 001st prime number?";
	}

}
