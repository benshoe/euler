package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;


/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 5, 2014
 */
public class Opdracht7 implements IEulerProblem {

	private String m_answer;

	@Override
	public void run() {
		int count = 1;
		int i = 3;
		while(count != 10000) {
			if(PrimeUtil.checkPrime(i += 2))
				count++;
		}
		System.out.println(i);
		m_answer = String.valueOf(i);
	}

	@Override
	public String getProblemName() {
		return "Problem 7: What is the 10 001st prime number?";
	}

	@Override
	public boolean isCorrectAnswer() {
		return "104743".equals(m_answer);
	}

}
