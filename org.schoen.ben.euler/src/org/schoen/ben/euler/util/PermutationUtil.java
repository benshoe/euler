package org.schoen.ben.euler.util;

import java.util.*;

/**
 * Get all the permutation for an int value
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 6, 2014
 */
public class PermutationUtil {

	public static int[] getPermutations(int value) {
		int[] perm = new int[String.valueOf(value).length()];
		createArrayFromValue(perm, value);
		Arrays.sort(perm);
		value = getPermValue(perm);
		int k = findHighestValidK(perm);
		int l = 0;
		int temp = 0;
		int counter = 1;
		int nrOfPerms = calculateNumberOfPermutations(perm);
		int[] perms = new int[nrOfPerms];
		perms[0] = value;
		while(counter <= nrOfPerms && k != -1) {
			l = findHighestValidL(perm, k);
			temp = perm[l];
			perm[l] = perm[k];
			perm[k] = temp;
			ArrayUtil.reverse(perm, k + 1);
			k = findHighestValidK(perm);
			perms[counter] = getPermValue(perm);
			counter++;
		}
		return perms;
	}

	private static int calculateNumberOfPermutations(int[] perm) {
		int[] m = new int[10];

		Set<Integer> distinctNumbers = new HashSet<>();
		for(int i = 0; i < perm.length; i++) {
			distinctNumbers.add(Integer.valueOf(perm[i]));
			m[perm[i]]++;
		}
		long possibleCombination = MathUtil.faculty(perm.length);
		for(int i : m) {
			if(i != 0)
				possibleCombination /= MathUtil.faculty(i);
		}
		return (int) possibleCombination;
	}

	private static void createArrayFromValue(int[] perm, int value) {
		String s = String.valueOf(value);
		for(int i = 0; i < s.length(); i++) {
			perm[i] = Integer.valueOf(s.substring(i, i + 1)).intValue();
		}
	}

	private static int getPermValue(int[] perm) {
		int value = 0;
		int pow = 1;
		for(int i : perm) {
			value += i * Math.pow(10, perm.length - pow);
			pow++;
		}
		return value;
	}

	private static int findHighestValidK(int[] perm) {
		for(int i = perm.length - 2; i >= 0; i--) {
			if(perm[i] < perm[i + 1])
				return i;
		}
		return -1;
	}

	private static int findHighestValidL(int[] perm, int k) {
		int posK = perm[k];
		for(int l = perm.length - 1; l > k; l--) {
			if(perm[l] > posK) {
				return l;
			}
		}
		return 0;
	}
}
