package org.schoen.ben.euler;

import java.util.*;

public class Problem17 implements IEulerProblem {

	public enum NUMBERS {
		ONE(3), TWO(3), THREE(5), FOUR(4), FIVE(4), SIX(3), SEVEN(5), EIGHT(5), NINE(4), TEN(3), //
		ELEVEN(6), TWELVE(6), THIRTEEN(8), FOURTEEN(8), FIFTEEN(7), //
		SIXTEEN(7), SEVENTEEN(9), EIGHTEEN(8), NINETEEN(8), TWENTY(6), //
		THIRTY(6), FORTY(5), FIFTY(5), SIXTY(5), //
		SEVENTY(7), EIGHTY(6), NINETY(6), HUNDRED(7), //
		THOUSAND(8);

		private int m_length;

		NUMBERS(int length) {
			m_length = length;
		}

		public int getLength() {
			return m_length;
		}
	};

	private static Map<String, Integer> m_numberMap = new HashMap<>();

	static {
		m_numberMap.put("0", new Integer(0));
		m_numberMap.put("00", new Integer(0));
		m_numberMap.put("1", new Integer(3)); //ONE
		m_numberMap.put("2", new Integer(3)); //TWO
		m_numberMap.put("3", new Integer(5)); //THREE
		m_numberMap.put("4", new Integer(4)); //FOUR
		m_numberMap.put("5", new Integer(4)); //FIVE
		m_numberMap.put("6", new Integer(3)); //SIX
		m_numberMap.put("7", new Integer(5)); //SEVEN
		m_numberMap.put("8", new Integer(5)); //EIGHT
		m_numberMap.put("9", new Integer(4)); //NINE
		m_numberMap.put("10", new Integer(3)); //TEN
		m_numberMap.put("11", new Integer(6)); //ELEVEN
		m_numberMap.put("12", new Integer(6)); //TWELVE
		m_numberMap.put("13", new Integer(8)); //THIRTEEN
		m_numberMap.put("14", new Integer(8)); //FOURTEEN
		m_numberMap.put("15", new Integer(7)); //FIFTEEN
		m_numberMap.put("16", new Integer(7)); //SIXTEEN
		m_numberMap.put("17", new Integer(9)); //SEVENTEEN
		m_numberMap.put("18", new Integer(8)); //EIGHTEEN
		m_numberMap.put("19", new Integer(8)); //NINETEEN
		m_numberMap.put("20", new Integer(6)); //TWENTY
		m_numberMap.put("30", new Integer(6)); //THIRTY
		m_numberMap.put("40", new Integer(5)); //FORTY
		m_numberMap.put("50", new Integer(5)); //FIFTY
		m_numberMap.put("60", new Integer(5)); //SIXTY
		m_numberMap.put("70", new Integer(7)); //SEVENTY
		m_numberMap.put("80", new Integer(6)); //EIGHTY
		m_numberMap.put("90", new Integer(6)); //NINETY
		m_numberMap.put("1000", new Integer(8)); //THOUSAND

	}

	@Override
	public void run() {
		int sum = 0;
		for(int i = 1; i <= 1000; i++) {
			if(m_numberMap.containsKey(String.valueOf(i))) {
				sum += m_numberMap.get(String.valueOf(i)).intValue();
				continue;
			}

			if(i < 100) {
				String s = String.valueOf(i);
				sum += m_numberMap.get(s.substring(0, 1) + "0").intValue();
				sum += m_numberMap.get(s.substring(1)).intValue();
				continue;
			}

			if(i < 1000) {
				String s = String.valueOf(i);
				sum += m_numberMap.get(s.substring(0, 1)).intValue();
				sum += 7; //HUNDRED
				if(i % 100 == 0) {
					//We're done because this is a round hundred value
					continue;
				}
				sum += 3; // AND as in TWO HUNDRED AND FIFTY ONE
				if(m_numberMap.containsKey(s.substring(1, 3))) {
					sum += m_numberMap.get(s.substring(1, 3)).intValue();
					continue;
				}
				sum += m_numberMap.get(s.substring(1, 2) + "0").intValue();
				sum += m_numberMap.get(s.substring(2)).intValue();
			}
		}
		System.out.println(sum);

	}

	@Override
	public String getProblemName() {
		return "Problem 17: If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?";
	}

	@Override
	public boolean isCorrectAnswer() {
		return false;
	}

}
