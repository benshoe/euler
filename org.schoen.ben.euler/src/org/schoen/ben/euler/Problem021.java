package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 19, 2014
 */
public class Problem021 extends AbstractEulerProblem {


	public Problem021(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int answer = 0;
		for(int i = 2; i < 10000; i++) {
			Integer sum = FactorUtil.getSumOfFactors(i);
			Integer sumBackwards = FactorUtil.getSumOfFactors(sum.intValue());
			if(i == sumBackwards.intValue() && sum.intValue() != i) {
				answer += sum.intValue();
			}
		}
		setAnswer(String.valueOf(answer));
	}

	@Override
	public String getProblemName() {
		return "Problem 21: Evaluate the sum of all the amicable numbers under 10000.";
	}

}
