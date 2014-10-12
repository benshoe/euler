package org.schoen.ben.euler;

/**
 * The following iterative sequence is defined for the set of positive integers:

 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)

 * Using the rule above and starting with 13, we generate the following sequence:

 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 11, 2014
 */
public class Problem14 implements IEulerProblem {

	private String m_answer;

	@Override
	public void run() {
		int collatzLength = 0;
		long collatzNumber = 1;
		for(long i = 1; i <= 1000000; i++) {
			int newCollatzLength = calculateCollatzSequence(i);
			if(newCollatzLength > collatzLength) {
				collatzLength = newCollatzLength;
				collatzNumber = i;
			}
		}
		System.out.println(collatzNumber + " has Collatz length " + collatzLength);
		m_answer = String.valueOf(collatzNumber);
	}

	private int calculateCollatzSequence(long i) {
		int count = 1;

		while(i != 1) {
			//			m_sequence.append(i).append(" ");
			if(i % 2 == 0) {
				i /= 2;
			} else {
				i = i * 3 + 1;
			}
			count++;
		}
		return count;
	}

	@Override
	public String getProblemName() {
		return "Problem 14: which starting number, under one million, produces the longest Collatz sequence";
	}

	@Override
	public boolean isCorrectAnswer() {
		return "837799".equals(m_answer);
	}

}
