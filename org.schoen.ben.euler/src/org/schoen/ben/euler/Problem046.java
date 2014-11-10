package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

/**
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 *
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 *
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 9, 2014
 */
public class Problem046 extends AbstractEulerProblem {

	public Problem046(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		long number = 9;
		boolean found = false;

		while(!found) {
			if(!PrimeUtil.isPrime(number)) {
				int square = 1;
				boolean squareFound = false;
				while(!squareFound && number > 2 * Math.pow(square, 2)) {
					if(!PrimeUtil.isPrime((long) (number - Math.pow(square, 2) * 2))) {
						square++;
					} else
						squareFound = true;
				}
				if(!squareFound) {
					found = true;
					setAnswer(String.valueOf(number));
				}
			}
			number += 2;
		}
	}

	@Override
	public String getProblemName() {
		return "Problem 46: What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?";
	}

}
