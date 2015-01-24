package org.schoen.ben.euler;

import java.math.*;

/**
 *
 * 1 + 1/2 = 3/2
 * 1 + 1/(2 + 1/2) = 7/5
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/24/15.
 */
public class Problem057 extends AbstractEulerProblem {

	public Problem057(String answer) {
		super(answer);
	}

	@Override public void run() {
		int answer = 0;
		BigInteger teller = new BigInteger("3");
		BigInteger noemer = new BigInteger("2");
		BigInteger previousNoemer = new BigInteger("2");
		BigInteger newNoemer;
		for(int i = 1; i <= 1000; i++) {
			newNoemer = teller.add(noemer);
			teller = previousNoemer.add(newNoemer);
			noemer = newNoemer;
			previousNoemer = noemer;
			if(teller.toString().length() > noemer.toString().length()) {
				answer++;
				//System.out.println(teller.toString().length() + "/" + noemer.toString().length());
			}
		}
		setAnswer(String.valueOf(answer));
	}

	@Override public String getProblemName() {
		return "Problem 57: In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?";
	}
}
