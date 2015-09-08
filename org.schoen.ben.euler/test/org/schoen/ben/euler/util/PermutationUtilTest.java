package org.schoen.ben.euler.util;

import org.junit.*;

public class PermutationUtilTest {

	@Test
	public void testGetPermutations() {
		long[] perms = PermutationUtil.getPermutations(123L);
		Assert.assertTrue(perms.length == 6);
		Assert.assertEquals(123, perms[0]);
		Assert.assertEquals(132, perms[1]);
		Assert.assertEquals(213, perms[2]);
		Assert.assertEquals(231, perms[3]);
		Assert.assertEquals(312, perms[4]);
		Assert.assertEquals(321, perms[5]);
	}

	@Test
	public void testGetUnorderedPerms() {
		long[] perms = PermutationUtil.getPermutations(231L);
		Assert.assertEquals(123, perms[0]);
		Assert.assertEquals(132, perms[1]);
		Assert.assertEquals(213, perms[2]);
		Assert.assertEquals(231, perms[3]);
		Assert.assertEquals(312, perms[4]);
		Assert.assertEquals(321, perms[5]);
	}

	@Test
	public void testPermutationEqualNumbers() {
		long[] perms = PermutationUtil.getPermutations(11);
		Assert.assertTrue(perms.length == 1);
		Assert.assertEquals(11, perms[0]);
	}

	@Test
	public void testPermutations() {
		long[] perms = PermutationUtil.getPermutations(1151);
		Assert.assertTrue(perms.length == 4);
	}

	@Test
	public void testPermutations3799() {
		long[] perms = PermutationUtil.getPermutations(3799);
		Assert.assertTrue(perms.length == 12);
		Assert.assertEquals(3799, perms[0]);
		Assert.assertEquals(3979, perms[1]);
		Assert.assertEquals(3997, perms[2]);
		Assert.assertEquals(7399, perms[3]);
		Assert.assertEquals(7939, perms[4]);
		Assert.assertEquals(7993, perms[5]);
		Assert.assertEquals(9379, perms[6]);
		Assert.assertEquals(9397, perms[7]);
		Assert.assertEquals(9739, perms[8]);
		Assert.assertEquals(9793, perms[9]);
		Assert.assertEquals(9937, perms[10]);
		Assert.assertEquals(9973, perms[11]);
	}

	@Test
	public void getCircularPermutations() {
		int[] perms = PermutationUtil.getCircularPermutations(1);
		Assert.assertTrue(perms.length == 1);
		Assert.assertEquals(1, perms[0]);

		perms = PermutationUtil.getCircularPermutations(15);
		Assert.assertTrue(perms.length == 2);
		Assert.assertEquals(15, perms[0]);
		Assert.assertEquals(51, perms[1]);

		perms = PermutationUtil.getCircularPermutations(179);
		Assert.assertTrue(perms.length == 3);
		Assert.assertEquals(179, perms[0]);
		Assert.assertEquals(791, perms[1]);
		Assert.assertEquals(917, perms[2]);
	}

	@Test
	public void getCircularStringPermutations() {
		String[] perms = PermutationUtil.getPermutations("abc");
		Assert.assertEquals(6, perms.length);
		Assert.assertEquals("abc", perms[0]);
		Assert.assertEquals("acb", perms[1]);
		Assert.assertEquals("bac", perms[2]);
		Assert.assertEquals("bca", perms[3]);
		Assert.assertEquals("cab", perms[4]);
		Assert.assertEquals("cba", perms[5]);
	}

	@Test
	public void testGetPermutationsOfLength() throws Exception {
		int[] perms = PermutationUtil.getPermutationsOfLength(new int[0], 0);
		Assert.assertEquals(0, perms.length);

		perms = PermutationUtil.getPermutationsOfLength(new int[]{2}, 1);
		Assert.assertEquals(1, perms.length);
		Assert.assertArrayEquals(perms, new int[]{2});

		perms = PermutationUtil.getPermutationsOfLength(new int[]{5, 8}, 1);
		Assert.assertEquals(2, perms.length);
		Assert.assertArrayEquals(perms, new int[]{5, 8});

		perms = PermutationUtil.getPermutationsOfLength(new int[]{5, 8, 9, 2}, 1);
		Assert.assertEquals(4, perms.length);
		Assert.assertArrayEquals(perms, new int[]{5, 8, 9, 2});

		perms = PermutationUtil.getPermutationsOfLength(new int[]{5, 8, 9, 2}, 2);
		Assert.assertEquals(12, perms.length);

	}
}
