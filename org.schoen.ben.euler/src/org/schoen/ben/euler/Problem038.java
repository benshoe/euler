package org.schoen.ben.euler;

import java.util.*;



/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
 * which is the concatenated product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 6, 2014
 */
public class Problem038 extends AbstractEulerProblem {

	public Problem038(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int answer = 0;
		for(int i = 2; i <= 50000; i++) {
			StringBuilder number = new StringBuilder(String.valueOf(i));
			int multiplier = 2;
			number.append(multiplier * i);
			while(number.length() < 9 && unique(number)) {
				multiplier++;
				number = number.append(multiplier * i);
			}
			if(number.length() == 9 && unique(number)) {
				answer = new Integer(number.toString()).intValue();
				System.out.print(i + "/");
				for(int j = 1; j <= multiplier; j++) {
					System.out.print(i * j + " ");
				}
				System.out.println();
			}
		}
		setAnswer(String.valueOf(answer));
	}

	private boolean unique(StringBuilder number) {
		if(number.toString().contains("0"))
			return false;
		Set<Integer> uniqueNumbers = new HashSet<>();
		for(int i = 0; i < number.length(); i++) {
			if(!uniqueNumbers.add(Integer.valueOf(number.substring(i, i + 1))))
				return false;
		}
		return true;
	}

	@Override
	public String getProblemName() {
		return "Problem 38: What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?";
	}

}
