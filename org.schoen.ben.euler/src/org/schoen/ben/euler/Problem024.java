package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 21, 2014
 */
public class Problem024 extends AbstractEulerProblem {

	public Problem024(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int[] perm = new int[]{0, 1, 2};
		long perms = MathUtil.faculty(perm.length);
		System.out.println(perms);
	}

	@Override
	public String getProblemName() {
		return "Problem 24: What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?";
	}

}
