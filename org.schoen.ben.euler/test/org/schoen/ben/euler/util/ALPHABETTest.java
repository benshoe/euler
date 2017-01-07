package org.schoen.ben.euler.util;

import org.junit.*;

/**
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since 12/26/16.
 */
public class ALPHABETTest {

	@Test
	public void testAlphabet() {
		ALPHABET a = ALPHABET.getLetter(1);
		Assert.assertEquals(ALPHABET.A, a);
		ALPHABET b = ALPHABET.getLetter(2);
		Assert.assertEquals(ALPHABET.B, b);
	}

	@Test(expected = IllegalStateException.class)
	public void testIllegalValue() {
		ALPHABET doesNotExist = ALPHABET.getLetter(27);
	}

}
