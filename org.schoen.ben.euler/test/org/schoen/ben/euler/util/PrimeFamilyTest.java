package org.schoen.ben.euler.util;

import junit.framework.Assert;
import org.junit.Test;

public class PrimeFamilyTest {

	@Test
	public void testEquality() {
		PrimeFamily pf54247 = new PrimeFamily();
		pf54247.setLength(5);
		pf54247.setPositions(new Integer[]{1,3});
		pf54247.setNumberLeft(527);

		PrimeFamily pf53237 = new PrimeFamily();
		pf53237.setLength(5);
		pf53237.setPositions(new Integer[]{1,3});
		pf53237.setNumberLeft(527);

		Assert.assertTrue(pf53237.equals(pf54247));
	}

	@Test
	public void testUnEqualityLength() {
		PrimeFamily pf54247 = new PrimeFamily();
		pf54247.setLength(5);
		pf54247.setPositions(new Integer[]{1,3});
		pf54247.setNumberLeft(527);

		PrimeFamily pf53237 = new PrimeFamily();
		pf53237.setLength(4);
		pf53237.setPositions(new Integer[]{1,3});
		pf53237.setNumberLeft(527);

		Assert.assertFalse(pf53237.equals(pf54247));
	}

	@Test
	public void testUnEqualityPosition() {
		PrimeFamily pf54247 = new PrimeFamily();
		pf54247.setLength(5);
		pf54247.setPositions(new Integer[]{1,3});
		pf54247.setNumberLeft(527);

		PrimeFamily pf53237 = new PrimeFamily();
		pf53237.setLength(5);
		pf53237.setPositions(new Integer[]{1,4});
		pf53237.setNumberLeft(527);

		Assert.assertFalse(pf53237.equals(pf54247));
	}

	@Test
	public void testUnEqualityNumberLeft() {
		PrimeFamily pf54247 = new PrimeFamily();
		pf54247.setLength(5);
		pf54247.setPositions(new Integer[]{1,3});
		pf54247.setNumberLeft(527);

		PrimeFamily pf53237 = new PrimeFamily();
		pf53237.setLength(5);
		pf53237.setPositions(new Integer[]{1,3});
		pf53237.setNumberLeft(517);

		Assert.assertFalse(pf53237.equals(pf54247));
	}
}
