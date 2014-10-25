package org.schoen.ben.euler.util;

public class ArrayUtil {

	public static void reverse(int[] perm, int fromIndex) {
		if(fromIndex >= perm.length) {
			return;
		}

		for(int i = 0; i < (perm.length - fromIndex) / 2; i++) {
			int temp = perm[fromIndex + i];
			perm[fromIndex + i] = perm[perm.length - 1 - i];
			perm[perm.length - 1 - i] = temp;
		}
	}

	public static void printArray(int[] perm) {
		for(int i = 0; i < perm.length; i++)
			System.out.print(perm[i]);
		System.out.println();
	}
}
