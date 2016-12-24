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
	public void testLowercaseTabulaRecta() {
		testTabulaRecta(VigenereDecoder.getTabulaRectaLowercase());
	}

	@Test
	public void testUppercaseTabulaRecta() {
		testTabulaRecta(VigenereDecoder.getTabulaRectaUppercase());
	}

	private void testTabulaRecta(Map<Character, List<Character>> tabulaRecta) {
		TextRotator rotator = new TextRotator();
		for(Entry<Character, List<Character>> entry : tabulaRecta.entrySet()) {
			Character key = entry.getKey();
			List<Character> characters = entry.getValue();
			System.out.print(key);
			System.out.println(" | " + characters);
			for(int i = 0; i < 26; i++) {
				String s = rotator.rotateText(String.valueOf(key), i);
				Assert.assertEquals(Character.toString(characters.get(i)), s);
			}
		}
	}

	@Test
	public void testSubstitutionLowerCase() {
		String codedText = "cwwqsjdsuoerdwp";
		String keyword = "zodiak";
		String decoded = m_vigenereDecoder.decode(codedText, keyword);
		Assert.assertEquals("ditiszeergeheim", decoded);
	}

	@Test
	public void testSubstitutionUpperCase() {
		String codedText = "CWWQSJDSUOERDWP";
		String keyword = "ZODIAK";
		String decoded = m_vigenereDecoder.decode(codedText, keyword);
		Assert.assertEquals("DITISZEERGEHEIM", decoded);
	}
}
