package org.schoen.ben.euler;

import java.util.*;

import org.schoen.ben.euler.util.*;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 *
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 11, 2014
 */
public class Problem050 extends AbstractEulerProblem {

	private static final int MAX_VALUE = 1000000;

	public Problem050(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int sum = 2;
		List<Integer> primes = new ArrayList<>();
		primes.add(new Integer(2));
		int i = 3;
		while(sum < MAX_VALUE) {
			if(PrimeUtil.isPrime(i)) {
				primes.add(new Integer(i));
				sum += i;
			}
			i += 2;
		}

		int largestPrime = 2;
		int consecutivePrimes = 0;
		for(int j = 0; j < primes.size() - 1; j++) {
			sum = 0;
			int counter = j;
			// Find the highest sum below the MAX_VALUE starting at each prime in the list
			while(sum < MAX_VALUE && counter < primes.size()) {
				sum += primes.get(counter).intValue();
				counter++;
			}

			// Now remove primes until the sum is a prime
			while(!PrimeUtil.isPrime(sum)) {
				sum -= primes.get(counter - 1).intValue();
				counter--;
			}

			// If the counter - j is greatest then that is the number of consecutive primes
			// The sum must also be larger then the largest prime found so far
			if(counter - j > consecutivePrimes && sum > largestPrime) {
				consecutivePrimes = counter - j;
				largestPrime = sum;
			}
		}
		setAnswer(String.valueOf(largestPrime));

	}

	@Override
	public String getProblemName() {
		return "Problem 50: Which prime, below one-million, can be written as the sum of the most consecutive primes?";
	}

}
