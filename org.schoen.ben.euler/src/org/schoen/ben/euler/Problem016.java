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
public class Problem016 implements IEulerProblem {

	private String m_answer;

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
		System.out.println(sum);
		System.out.println(count);
		m_answer = String.valueOf(sum);
	}

	@Override
	public String getProblemName() {
		return "What is the sum of the digits of the number 2^1000?";
	}

	@Override
	public boolean isCorrectAnswer() {
		return "1366".equals(m_answer);
	}

}
