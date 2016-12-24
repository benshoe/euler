package org.schoen.ben.kerstpuzzel;

import java.util.*;

import static java.lang.Character.isLowerCase;

/**
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since 12/22/16.
 */
public class VigenereDecoder {

	private static Map<Character, List<Character>> m_tabulaRectaLowercase = new HashMap<>(26);

	private static Map<Character, List<Character>> m_tabulaRectaUppercase = new HashMap<>(26);

	static {
		TextRotator rotator = new TextRotator();
		int counter = 0;
		for(int row = 0; row < 26; row++) {
			List<Character> lowerCharacters = new ArrayList<>(26);
			List<Character> upperCharacters = new ArrayList<>(26);
			m_tabulaRectaUppercase.put(new Character((char) (row + 65)), upperCharacters);
			m_tabulaRectaLowercase.put(new Character((char) (row + 97)), lowerCharacters);
			for(int col = 0; col < 26; col++) {
				String lowerLetter = rotator.rotateText(String.valueOf((char) (col + 97)), counter);
				lowerCharacters.add(lowerLetter.charAt(0));
				String upperLetter = rotator.rotateText(String.valueOf((char) (col + 65)), counter);
				upperCharacters.add(upperLetter.charAt(0));
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
		if(isLowerCase(character)) {
			int i = m_tabulaRectaLowercase.get(keywordLetter).indexOf(character);
			List<Character> characters = m_tabulaRectaLowercase.get('a');
			Character foundChar = characters.get(i);
			return foundChar;
		}
		int i = m_tabulaRectaUppercase.get(keywordLetter).indexOf(character);
		List<Character> characters = m_tabulaRectaUppercase.get('A');
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

	public static Map<Character, List<Character>> getTabulaRectaLowercase() {
		return m_tabulaRectaLowercase;
	}

	public static Map<Character, List<Character>> getTabulaRectaUppercase() {
		return m_tabulaRectaUppercase;
	}

}
