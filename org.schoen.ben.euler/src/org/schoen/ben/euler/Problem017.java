package org.schoen.ben.euler;

import java.util.*;

public class Problem017 extends AbstractEulerProblem {

	public Problem017(String answer) {
		super(answer);
	}

	public enum NUMBERS {
		ONE(3), TWO(3), THREE(5), FOUR(4), FIVE(4), SIX(3), SEVEN(5), EIGHT(5), NINE(4), TEN(3), //
		ELEVEN(6), TWELVE(6), THIRTEEN(8), FOURTEEN(8), FIFTEEN(7), //
		SIXTEEN(7), SEVENTEEN(9), EIGHTEEN(8), NINETEEN(8), TWENTY(6), //
		THIRTY(6), FORTY(5), FIFTY(5), SIXTY(5), //
		SEVENTY(7), EIGHTY(6), NINETY(6), HUNDRED(7), //
		ONE_THOUSAND(11), NONE(0);

		private int m_length;

		NUMBERS(int length) {
			m_length = length;
		}

		public int getLength() {
			return m_length;
		}
	};

	private static Map<String, NUMBERS> m_numberMap = new HashMap<>();

	static {
		m_numberMap.put("0", NUMBERS.NONE);
		m_numberMap.put("00", NUMBERS.NONE);
		m_numberMap.put("1", NUMBERS.ONE); //ONE
		m_numberMap.put("2", NUMBERS.TWO); //TWO
		m_numberMap.put("3", NUMBERS.THREE); //THREE
		m_numberMap.put("4", NUMBERS.FOUR); //FOUR
		m_numberMap.put("5", NUMBERS.FIVE); //FIVE
		m_numberMap.put("6", NUMBERS.SIX); //SIX
		m_numberMap.put("7", NUMBERS.SEVEN); //SEVEN
		m_numberMap.put("8", NUMBERS.EIGHT); //EIGHT
		m_numberMap.put("9", NUMBERS.NINE); //NINE
		m_numberMap.put("10", NUMBERS.TEN); //TEN
		m_numberMap.put("11", NUMBERS.ELEVEN); //ELEVEN
		m_numberMap.put("12", NUMBERS.TWELVE); //TWELVE
		m_numberMap.put("13", NUMBERS.THIRTEEN); //THIRTEEN
		m_numberMap.put("14", NUMBERS.FOURTEEN); //FOURTEEN
		m_numberMap.put("15", NUMBERS.FIFTEEN); //FIFTEEN
		m_numberMap.put("16", NUMBERS.SIXTEEN); //SIXTEEN
		m_numberMap.put("17", NUMBERS.SEVENTEEN); //SEVENTEEN
		m_numberMap.put("18", NUMBERS.EIGHTEEN); //EIGHTEEN
		m_numberMap.put("19", NUMBERS.NINETEEN); //NINETEEN
		m_numberMap.put("20", NUMBERS.TWENTY); //TWENTY
		m_numberMap.put("30", NUMBERS.THIRTY); //THIRTY
		m_numberMap.put("40", NUMBERS.FORTY); //FORTY
		m_numberMap.put("50", NUMBERS.FIFTY); //FIFTY
		m_numberMap.put("60", NUMBERS.SIXTY); //SIXTY
		m_numberMap.put("70", NUMBERS.SEVENTY); //SEVENTY
		m_numberMap.put("80", NUMBERS.EIGHTY); //EIGHTY
		m_numberMap.put("90", NUMBERS.NINETY); //NINETY
		m_numberMap.put("100", NUMBERS.HUNDRED); //HUNDRED
		m_numberMap.put("1000", NUMBERS.ONE_THOUSAND); //THOUSAND

	}

	@Override
	public void run() {
		int sum = 0;
		for(int i = 1; i <= 1000; i++) {
			//			System.out.println(" " + sum);
			if(i == 100) {
				sum += 10;
				continue;
			}
			if(m_numberMap.containsKey(String.valueOf(i))) {
				sum += m_numberMap.get(String.valueOf(i)).getLength();
				//				System.out.print(m_numberMap.get(String.valueOf(i)) + " ");
				continue;
			}

			if(i < 100) {
				String s = String.valueOf(i);
				sum += m_numberMap.get(s.substring(0, 1) + "0").getLength();
				//				System.out.print(m_numberMap.get(s.substring(0, 1) + "0") + " ");
				sum += m_numberMap.get(s.substring(1)).getLength();
				//				System.out.print(m_numberMap.get(s.substring(1)) + " ");
				continue;
			}

			if(i < 1000) {
				String s = String.valueOf(i);
				sum += m_numberMap.get(s.substring(0, 1)).getLength();
				//				System.out.print(m_numberMap.get(s.substring(0, 1)) + " ");
				sum += m_numberMap.get("100").getLength(); //HUNDRED
				//				System.out.print(m_numberMap.get("100") + " ");
				if(i % 100 == 0) {
					//We're done because this is a round hundred value
					continue;
				}
				sum += 3; // AND as in TWO HUNDRED AND FIFTY ONE
				//				System.out.print("AND ");
				if(m_numberMap.containsKey(s.substring(1, 3))) {
					sum += m_numberMap.get(s.substring(1, 3)).getLength();
					//					System.out.print(m_numberMap.get(s.substring(1, 3)) + " ");
					continue;
				}
				sum += m_numberMap.get(s.substring(1, 2) + "0").getLength();
				//				System.out.print(m_numberMap.get(s.substring(1, 2) + "0") + " ");
				sum += m_numberMap.get(s.substring(2)).getLength();
				//				System.out.print(m_numberMap.get(s.substring(2)));
			}
		}
		setAnswer(String.valueOf(sum));
	}

	@Override
	public String getProblemName() {
		return "Problem 17: If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?";
	}

}
