package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

/**
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side length 7 is formed.

 37 36 35 34 33 32 31
 38 17 16 15 14 13 30
 39 18  5  4  3 12 29
 40 19  6  1  2 11 28
 41 20  7  8  9 10 27
 42 21 22 23 24 25 26
 43 44 45 46 47 48 49

 It is interesting to note that the odd squares lie along the bottom right diagonal,
 but what is more interesting is that 8 out of the 13 numbers lying along both diagonals are prime;
 that is, a ratio of 8/13 ≈ 62%.

 If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed.
 If this process is continued, what is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/24/15.
 */
public class Problem058 extends AbstractEulerProblem {
	public Problem058(String answer) {
		super(answer);
	}

	@Override public void run() {
		double percentage = 1;
		long round = 3;
		double numberOfPrimes = 0;
		double numbersOnDiagonal = 0;
		while(percentage > 0.1) {
			numbersOnDiagonal += 4;
			long i2 = (long) Math.pow(round, 2);
			numberOfPrimes += getNumberOfPrimes(i2, round - 1);
			round += 2;
			percentage = numberOfPrimes / numbersOnDiagonal;
		}
		setAnswer(String.valueOf(round - 2));
	}

	private int getNumberOfPrimes(long i2, long round) {
		int numberOfPrimes = 0;
		if(PrimeUtil.isPrime(i2))
			numberOfPrimes++;
		if(PrimeUtil.isPrime(i2 - (round)))
			numberOfPrimes++;
		if(PrimeUtil.isPrime(i2 - (round * 2)))
			numberOfPrimes++;
		if(PrimeUtil.isPrime(i2 - (round * 3)))
			numberOfPrimes++;
		return numberOfPrimes;
	}

	@Override public String getProblemName() {
		return "Problem 58: What is the side length of the square spiral for which the ratio of primes along both diagonals first falls below 10%?";
	}
}
