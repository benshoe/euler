package org.schoen.ben.euler;

import java.util.*;

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
			List<Integer> factors = getFactors(i);
			if(factors != Collections.EMPTY_LIST) {
				Integer sum = getSumOfFactors(factors);
				List<Integer> otherWayAround = getFactors(sum.intValue());
				Integer sumBackwards = getSumOfFactors(otherWayAround);
				if(i == sumBackwards.intValue() && sum.intValue() != i) {
					answer += sum.intValue();
				}
			}
		}
		setAnswer(String.valueOf(answer));
	}

	private Integer getSumOfFactors(List<Integer> factors) {
		int sum = 0;
		for(Integer integer : factors) {
			sum += integer.intValue();
		}
		return Integer.valueOf(sum);
	}

	private List<Integer> getFactors(int i) {
		if(PrimeUtil.checkPrime(i)) {
			return Collections.EMPTY_LIST;
		}

		List<Integer> factors = new ArrayList<>();
		factors.add(new Integer("1"));
		int sqr = (int) Math.sqrt(i) + 1;
		for(int x = 2; x < sqr; x++) {
			int factor = i / x;
			if(i % x == 0) {
				factors.add(new Integer(x));
				if(x != factor) {
					factors.add(new Integer(factor));
				}
			}
		}
		return factors;
	}

	@Override
	public String getProblemName() {
		return "Problem 21: Evaluate the sum of all the amicable numbers under 10000.";
	}

}
