package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;


/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * Created on Oct 3, 2014
 */
public class Opdracht3 implements IEulerProblem {

	private String m_answer;

	@Override
	public void run() {
		long value = 600851475143l;
		long startNumber = (long) Math.sqrt(value);
		System.out.println(startNumber);
		if(startNumber % 2 == 0)
			startNumber--;

		while(startNumber > 3) {
			if(value % startNumber == 0) {
				if(PrimeUtil.checkPrime(startNumber)) {
					System.out.println("The factor is: " + startNumber);
					break;
				}
			}
			startNumber -= 2;
		}
		m_answer = String.valueOf(startNumber);
	}

	@Override
	public String getProblemName() {
		return "Problem 3: What is the largest prime factor of the number 600851475143 ?";
	}

	@Override
	public boolean isCorrectAnswer() {
		return "6857".equals(m_answer);
	}
}
