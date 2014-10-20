package org.schoen.ben.euler;

import java.util.*;

import org.schoen.ben.euler.util.*;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be
 * written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown
 * that all integers greater than 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis even though it is known
 * that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 20, 2014
 */
public class Problem023 extends AbstractEulerProblem {

	public Problem023(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		List<Integer> abundantNumbers = new ArrayList<>();
		List<Integer> allNumbers = new ArrayList<>();
		for(int i = 1; i < 28123; i++) {
			Integer sumOfFactors = FactorUtil.getSumOfFactors(i);
			allNumbers.add(Integer.valueOf(i));
			if(sumOfFactors.intValue() > i) {
				abundantNumbers.add(Integer.valueOf(i));
			}
		}
		System.out.println(abundantNumbers);
		System.out.println(allNumbers);

		for(int i = 0; i < abundantNumbers.size(); i++) {
			for(int j = i; j < abundantNumbers.size(); j++) {
				int sumOfTwoAbundantNumbers = abundantNumbers.get(i).intValue() + abundantNumbers.get(j).intValue();
				allNumbers.remove(Integer.valueOf(sumOfTwoAbundantNumbers));
			}
		}
		int sum = 0;
		for(Integer integer : allNumbers) {
			sum += integer.intValue();
		}
		setAnswer(String.valueOf(sum));
	}

	@Override
	public String getProblemName() {
		return "Problem 23: Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.";
	}

}
