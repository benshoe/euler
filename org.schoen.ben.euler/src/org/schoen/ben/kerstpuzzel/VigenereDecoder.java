package org.schoen.ben.kerstpuzzel;

import java.util.*;

/**
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since 12/22/16.
 */
public class VigenereDecoder {

	private static Map<Character, List<Character>> m_tabulaRecta = new HashMap<>(26);

	static {
		TextRotator rotator = new TextRotator();
		int counter = 0;
		for(int row = 0; row < 26; row++) {
			List<Character> characters = new ArrayList<>(26);
			m_tabulaRecta.put(new Character((char) (row + 97)), characters);
			for(int col = 0; col < 26; col++) {
				String s = rotator.rotateText(String.valueOf((char) (col + counter + 97)), 0);
				characters.add(s.charAt(0));
			}
			counter++;
		}
	}

	public String decode(String codedText, String keyword) {
		int codedTextSize = codedText.length();
		StringBuilder decodedText = new StringBuilder(codedTextSize);
		int currentPosition = 0;
		while(currentPosition < codedTextSize) {
			decodedText.append(getClearLetter(codedText.charAt(currentPosition), keyword, currentPosition));
			currentPosition++;
		}
		return decodedText.toString();
	}

	private Character getClearLetter(char codedChar, String keyword, int currentPosition) {
		Character keywordLetter = getKeywordLetter(keyword, currentPosition);
		return findLetterInMap(keywordLetter, Character.valueOf(codedChar));
	}

	private Character findLetterInMap(Character keywordLetter, Character character) {
		int i = m_tabulaRecta.get(keywordLetter).indexOf(character);
		List<Character> characters = m_tabulaRecta.get('a');
		Character foundChar = characters.get(i);
		return foundChar;
	}

	private Character getKeywordLetter(String keyword, int currentPosition) {
		if(currentPosition == 0) {
			return keyword.charAt(0);
		}
		int realPosition = currentPosition % keyword.length();
		return keyword.charAt(realPosition);
	}

	public static Map<Character, List<Character>> getTabulaRecta() {
		return m_tabulaRecta;
	}

}
