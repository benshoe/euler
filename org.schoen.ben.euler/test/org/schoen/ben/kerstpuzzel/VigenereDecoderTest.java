package org.schoen.ben.kerstpuzzel;

import org.junit.*;

import java.util.*;
import java.util.Map.*;

/**
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since 12/22/16.
 */
public class VigenereDecoderTest {

	VigenereDecoder m_vigenereDecoder = new VigenereDecoder();

	@Test
	public void testWithoutSubstitution() {
		String clearText = "abcdefg";
		String keyword = "a";
		String decode = m_vigenereDecoder.decode(clearText, keyword);
		Assert.assertEquals("abcdefg", decode);
	}

	@Test
	public void testTabulaRecta() {
		Map<Character, List<Character>> tabulaRecta = VigenereDecoder.getTabulaRecta();
		for(Entry<Character, List<Character>> entry : tabulaRecta.entrySet()) {
			System.out.print(entry.getKey());
			System.out.println(" | " + entry.getValue());
		}
	}

	@Test
	public void testSubstitutionLowerCase() {
		String codedText = "cwwqsjdsuoerdwp";
		String keyword = "zodiak";
		String decoded = m_vigenereDecoder.decode(codedText, keyword);
		Assert.assertEquals("ditiszeergeheim", decoded);
	}
}
