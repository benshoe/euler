package org.schoen.ben.euler.util;

import junit.framework.Assert;
import org.junit.Test;

public class PrimeFamilyTest {

	@Test
	public void testEquality() {
		PrimeFamily pf54247 = new PrimeFamily();
		pf54247.setLength(5);
		pf54247.setPositions(new Integer[]{1,3});
		pf54247.setNumberDuplicates(2);
		pf54247.setNumberLeft(527);

		PrimeFamily pf53237 = new PrimeFamily();
		pf53237.setLength(5);
		pf53237.setPositions(new Integer[]{1,3});
		pf53237.setNumberDuplicates(2);
		pf53237.setNumberLeft(527);

		Assert.assertTrue(pf53237.equals(pf54247));
	}

	@Test
	public void testUnEqualityLength() {
		PrimeFamily pf54247 = new PrimeFamily();
		pf54247.setLength(5);
		pf54247.setPositions(new Integer[]{1,3});
		pf54247.setNumberDuplicates(2);
		pf54247.setNumberLeft(527);

		PrimeFamily pf53237 = new PrimeFamily();
		pf53237.setLength(4);
		pf53237.setPositions(new Integer[]{1,3});
		pf53237.setNumberDuplicates(2);
		pf53237.setNumberLeft(527);

		Assert.assertFalse(pf53237.equals(pf54247));
	}

	@Test
	public void testUnEqualityPosition() {
		PrimeFamily pf54247 = new PrimeFamily();
		pf54247.setLength(5);
		pf54247.setPositions(new Integer[]{1,3});
		pf54247.setNumberDuplicates(2);
		pf54247.setNumberLeft(527);

		PrimeFamily pf53237 = new PrimeFamily();
		pf53237.setLength(5);
		pf53237.setPositions(new Integer[]{1,4});
		pf53237.setNumberDuplicates(2);
		pf53237.setNumberLeft(527);

		Assert.assertFalse(pf53237.equals(pf54247));
	}

	@Test
	public void testUnEqualityNumberLeft() {
		PrimeFamily pf54247 = new PrimeFamily();
		pf54247.setLength(5);
		pf54247.setPositions(new Integer[]{1,3});
		pf54247.setNumberDuplicates(2);
		pf54247.setNumberLeft(527);

		PrimeFamily pf53237 = new PrimeFamily();
		pf53237.setLength(5);
		pf53237.setPositions(new Integer[]{1,3});
		pf53237.setNumberDuplicates(2);
		pf53237.setNumberLeft(517);

		Assert.assertFalse(pf53237.equals(pf54247));
	}

	@Test
	public void testFamilyOfTwo () {
		PrimeFamily pf13 = new PrimeFamily(); // number 13
		pf13.setLength(2);
		pf13.setCommon(1);
		pf13.setNumberDuplicates(1);
		pf13.setPositions(new Integer[]{1});
		pf13.setNumberLeft(3);

		PrimeFamily pf23 = new PrimeFamily(); // number 23
		pf23.setLength(2);
		pf23.setCommon(2);
		pf23.setNumberDuplicates(1);
		pf23.setPositions(new Integer[]{1});
		pf23.setNumberLeft(3);

		Assert.assertEquals(pf13, pf23);
	}
}
