package org.schoen.ben.euler;

import java.math.*;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 11, 2014
 */
public class Problem016 extends AbstractEulerProblem {

	public Problem016(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		BigInteger large = new BigInteger("2").pow(1000);
		System.out.println(large);
		String s = large.toString();
		long sum = 0;
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			sum += s.charAt(i) - 48;
			count++;
		}
		setAnswer(String.valueOf(sum));
	}

	@Override
	public String getProblemName() {
		return "What is the sum of the digits of the number 2^1000?";
	}

}
