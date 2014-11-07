package org.schoen.ben.euler;


/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 *
 * 0.123456789101112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 *
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 7, 2014
 */
public class Problem040 extends AbstractEulerProblem {

	public Problem040(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		long answer = 1;
		StringBuilder sb = new StringBuilder();
		for(long i = 1; i <= 1000000; i++) {
			sb.append(i);
		}
		answer *= sb.charAt(0) - 48;
		answer *= sb.charAt(9) - 48;
		answer *= sb.charAt(99) - 48;
		answer *= sb.charAt(999) - 48;
		answer *= sb.charAt(9999) - 48;
		answer *= sb.charAt(99999) - 48;
		answer *= sb.charAt(999999) - 48;

		setAnswer(String.valueOf(answer));
	}

	@Override
	public String getProblemName() {
		return "Problem 40: d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000.";
	}

}
