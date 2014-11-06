package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

/**
 * Considering quadratics of the form:
 *
 * n² + an + b, where |a| < 1000 and |b| < 1000
 *
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |−4| = 4
 * Find the product of the coefficients, a and b, for the quadratic expression that
 * produces the maximum number of primes for consecutive values of n, starting with n = 0.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 29, 2014
 */
public class Problem027 extends AbstractEulerProblem {


	public Problem027(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int factor = 0;
		int numberOfPrimesSofar = 1;
		int numberOfPrimes = 0;
		for(int b = 3; b < 1000; b += 2) {
			if(PrimeUtil.isPrime(b)) {
				int sum = b;
				for(int a = -b + 1; a < b; a++) {
					numberOfPrimesSofar = 1;
					for(int n = 0; n < b; n++) {
						sum = n * n + a * n + b;
						if(PrimeUtil.isPrime(sum)) {
							numberOfPrimesSofar++;
						} else {
							break;
						}
					}
					if(numberOfPrimesSofar > numberOfPrimes) {
						numberOfPrimes = numberOfPrimesSofar;
						factor = a * b;
					}
				}
			}
		}
		System.out.println(factor);
		setAnswer(String.valueOf(factor));
	}

	@Override
	public String getProblemName() {
		return "Problem 27: Find the maximum number of primes for a quadratic formula";
	}

}
