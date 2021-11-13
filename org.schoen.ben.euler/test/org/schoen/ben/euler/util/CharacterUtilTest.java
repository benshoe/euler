package org.schoen.ben.euler.util;

import static org.junit.Assert.*;

import org.junit.*;

/**
 * @author <a href="mailto:ben.schoen@ns.nl">Ben Schoen</a>
 * @since 20-12-20.
 */
public class CharacterUtilTest {

	@Test
	public void heeftRepeatingCharsTest() {
		String woord = "abcde";
		boolean b = CharacterUtil.heeftRepeatingChars(woord);
		Assert.assertFalse(b);

		woord = "aa";
		b = CharacterUtil.heeftRepeatingChars(woord);
		Assert.assertTrue(b);

		woord = "baaaabbb";
		b = CharacterUtil.heeftRepeatingChars(woord);
		Assert.assertTrue(b);

		woord = "aaab";
		b = CharacterUtil.heeftRepeatingChars(woord);
		Assert.assertTrue(b);
	}

	@Test
	public void heeftAlleenMedeklinkers() {
		String woord = "BCDFGHJKLMNPQRSTVWXYZ";
		Assert.assertTrue(CharacterUtil.heeftAlleenMedeklinkers(woord));

		woord = "AEIOU";
		Assert.assertFalse(CharacterUtil.heeftAlleenMedeklinkers(woord));

		woord = "ABCDE";
		Assert.assertFalse(CharacterUtil.heeftAlleenMedeklinkers(woord));
	}

}
