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
		int[] perm = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

		int k = findHighestValidK(perm);
		int l = 0;
		int temp = 0;
		int counter = 1;
		while(counter <= 999999 && k != -1) {
			l = findHighestValidL(perm, k);
			temp = perm[l];
			perm[l] = perm[k];
			perm[k] = temp;
			ArrayUtil.reverse(perm, k + 1);
			k = findHighestValidK(perm);
			counter++;
		}
		ArrayUtil.printArray(perm);

	}

	private int findHighestValidK(int[] perm) {
		for(int i = perm.length - 2; i >= 0; i--) {
			if(perm[i] < perm[i + 1])
				return i;
		}
		return -1;
	}

	private int findHighestValidL(int[] perm, int k) {
		int posK = perm[k];
		for(int l = perm.length - 1; l > k; l--) {
			if(perm[l] > posK) {
				return l;
			}
		}
		return 0;
	}




	@Override
	public String getProblemName() {
		return "Problem 24: What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?";
	}

}
