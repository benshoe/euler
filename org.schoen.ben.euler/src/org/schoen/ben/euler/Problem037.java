package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;


/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right,
 * and remain prime at each stage: 3797, 797, 97, and 7.
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 6, 2014
 */
public class Problem037 extends AbstractEulerProblem {

	public Problem037(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int found = 0;
		int number = 11;
		int answer = 0;
		while(found < 11) {
			if(PrimeUtil.checkPrime(number)) {
				String num = String.valueOf(number);
				boolean allPrimes = true;
				int i = 1;
				while(i < num.length()) {
					if(!PrimeUtil.checkPrime(Long.valueOf(num.substring(i)).longValue())) {
						allPrimes = false;
					}
					i++;
				}
				i = num.length() - 1;
				while(i > 0) {
					if(!PrimeUtil.checkPrime(Long.valueOf(num.substring(0, i)))) {
						allPrimes = false;
					}
					i--;
				}
				if(allPrimes) {
					answer += number;
					System.out.println(number);
					found++;
				}
			}
			number += 2;
		}
		setAnswer(String.valueOf(answer));
	}

	@Override
	public String getProblemName() {
		return "Problem 37: Find the sum of the only eleven primes that are both truncatable from left to right and right to left.";
	}

}
