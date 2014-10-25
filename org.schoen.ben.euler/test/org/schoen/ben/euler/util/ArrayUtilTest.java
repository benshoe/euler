package org.schoen.ben.euler.util;

import org.junit.*;

public class ArrayUtilTest {

	@Test
	public void testReverse() {
		int[] perm = new int[]{};
		ArrayUtil.printArray(perm);
		ArrayUtil.reverse(perm, 0);
		ArrayUtil.printArray(perm);
		Assert.assertArrayEquals("Verwacht: []", new int[0], perm);

		perm = new int[]{1};
		ArrayUtil.printArray(perm);
		ArrayUtil.reverse(perm, 0);
		ArrayUtil.printArray(perm);
		Assert.assertArrayEquals("Verwacht: 1", new int[]{1}, perm);

		perm = new int[]{1, 2, 3, 4};
		ArrayUtil.printArray(perm);
		ArrayUtil.reverse(perm, 1);
		ArrayUtil.printArray(perm);
		Assert.assertArrayEquals("Verwacht: 1 4 3 2", new int[]{1, 4, 3, 2}, perm);

		perm = new int[]{1, 2, 3, 4};
		ArrayUtil.printArray(perm);
		ArrayUtil.reverse(perm, 0);
		ArrayUtil.printArray(perm);
		Assert.assertArrayEquals("Verwacht: 4 3 2 1", new int[]{4, 3, 2, 1}, perm);

		perm = new int[]{1, 2, 3, 0};
		ArrayUtil.printArray(perm);
		ArrayUtil.reverse(perm, 1);
		ArrayUtil.printArray(perm);
		Assert.assertArrayEquals("Verwacht: 1 0 3 2", new int[]{1, 0, 3, 2}, perm);

		perm = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
		ArrayUtil.printArray(perm);
		ArrayUtil.reverse(perm, 1);
		ArrayUtil.printArray(perm);
		Assert.assertArrayEquals("Verwacht: 0 7 6 5 4 3 2 1", new int[]{0, 7, 6, 5, 4, 3, 2, 1}, perm);

		perm = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		ArrayUtil.printArray(perm);
		ArrayUtil.reverse(perm, 4);
		ArrayUtil.printArray(perm);
		Assert.assertArrayEquals("Verwacht: 0 1 2 3 12 11 10 9 8 7 6 5 4", new int[]{0, 1, 2, 3, 12, 11, 10, 9, 8, 7, 6, 5, 4}, perm);
	}

}
