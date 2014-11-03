package org.schoen.ben.euler;

import java.util.*;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once;
 * for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 3, 2014
 */
public class Problem032 extends AbstractEulerProblem {

	public Problem032(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int answer = 0;
		Set<Integer> answers = new HashSet<>();
		for(int i = 1; i < 9999; i++) {
			if(i % 10 == 0)
				continue;
			for(int j = 1; j < 999; j++) {
				if(j % 10 == 0)
					continue;
				int sum = i * j;
				if(sum > 987654321)
					break;
				if(verify(i, j, sum)) {
					answers.add(Integer.valueOf(sum));
				}
			}
		}
		for(Integer product : answers) {
			answer += product.intValue();
		}
		setAnswer(String.valueOf(answer));
	}

	private boolean verify(int i, int j, int sum) {
		String m1 = String.valueOf(i);
		String m2 = m1 + String.valueOf(j);
		String product = m2 + String.valueOf(sum);
		if(product.length() != 9) {
			return false;
		}
		if(product.contains("0")) {
			return false;
		}
		if(product.contains("1") && product.contains("2") && product.contains("3") && product.contains("4") && product.contains("5") && product.contains("6") && product.contains("7")
			&& product.contains("8") && product.contains("9")) {
			return true;
		}
			return false;
	}

	@Override
	public String getProblemName() {
		return "Problem 32: Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.";
	}

}
