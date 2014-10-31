package org.schoen.ben.euler;

import java.util.*;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 1^4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 29, 2014
 */
public class Problem030 extends AbstractEulerProblem {

	private static Map<String, Integer> values = new HashMap<>();

	static {
		values.put("0", new Integer(0));
		values.put("1", new Integer(1));
		values.put("2", new Integer(32));
		values.put("3", new Integer(243));
		values.put("4", new Integer(1024));
		values.put("5", new Integer(3125));
		values.put("6", new Integer(7776));
		values.put("7", new Integer(16807));
		values.put("8", new Integer(32768));
		values.put("9", new Integer(59049));
	}

	public Problem030(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int answer = 0;
		for(int i = 2; i < 360000; i++) {
			String s = String.valueOf(i);
			if(translate(s) == i) {
				answer += i;
			}
		}
		setAnswer(String.valueOf(answer));
	}

	private int translate(String s) {
		int val = 0;
		for(int i = 0; i < s.length(); i++) {
			String key = String.valueOf(s.charAt(i));
			val += values.get(key).intValue();
			//			System.out.println(val);
		}
		return val;
	}

	@Override
	public String getProblemName() {
		return "Problem 30: Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.";
	}

}
