package org.schoen.ben.euler;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 *
 * (a + b + c)^2 = a^2 + b^2 + c^2 + ab + ac + bc + ba + bc + ca + cb
 * 				 = a^2 + b^2 + c^2 + 2ab + 2ac + 2bc
 *
 * The difference with a^2 + b^2 + c^2 is therefore: 2ab + 2ac + 2bc
 * So all combinations multiplied is the answer!
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 3, 2014
 */
public class Problem005 implements IEulerProblem {

	private String m_answer;

	@Override
	public void run() {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				sum += i * j;
			}
			sum -= i * i;
		}
		System.out.println(sum);
		m_answer = String.valueOf(sum);
	}

	@Override
	public String getProblemName() {
		return "Problem 5: What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?";
	}

	@Override
	public boolean isCorrectAnswer() {
		return "25164150".equals(m_answer);
	}

}
