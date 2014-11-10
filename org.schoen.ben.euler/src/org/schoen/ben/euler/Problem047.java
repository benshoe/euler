package org.schoen.ben.euler;

import java.util.*;

import org.schoen.ben.euler.util.*;


/**
 * The first two consecutive numbers to have two distinct prime factors are:
 *
 * 14 = 2 × 7
 * 15 = 3 × 5
 *
 * The first three consecutive numbers to have three distinct prime factors are:
 *
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 *
 * Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 10, 2014
 */
public class Problem047 extends AbstractEulerProblem {

	public Problem047(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		boolean found = false;
		int a = 1;
		while(!found) {
			if(checkPrimeFactors(a)) {
				if(checkPrimeFactors(a + 1)) {
					if(checkPrimeFactors(a + 2)) {
						if(checkPrimeFactors(a + 3)) {
							found = true;
						} else {
							a = a + 4;
						}
					} else {
						a = a + 3;
					}
				} else {
					a = a + 2;
				}
			} else {
				a = a + 1;
			}
		}
		setAnswer(String.valueOf(a));
	}

	private boolean checkPrimeFactors(int a) {
		List<Integer> factors = FactorUtil.getFactors(a);
		if(factors.size() < 4)
			return false;
		int primes = 0;
		for(Integer i : factors) {
			if(PrimeUtil.isPrime(i))
				primes++;
		}
		return primes == 4;
	}

	@Override
	public String getProblemName() {
		return "Problem 47: Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?";
	}

}
