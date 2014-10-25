package org.schoen.ben.euler;

import java.math.*;

/**
 * he Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 25, 2014
 */
public class Problem025 extends AbstractEulerProblem {

	public Problem025(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		BigInteger first = BigInteger.ONE;
		BigInteger second = BigInteger.ONE;
		BigInteger fibonacci = BigInteger.ZERO;
		int counter = 2;
		while(fibonacci.toString().length() < 1000) {
			fibonacci = first.add(second);
			first = second;
			second = fibonacci;
			counter++;
		}
		System.out.println(fibonacci);
		System.out.println(counter);
	}

	@Override
	public String getProblemName() {
		return "Problem 25: What is the first term in the Fibonacci sequence to contain 1000 digits?";
	}

}
