package org.schoen.ben.euler.util;

import java.math.*;
import java.util.*;

public class PrimeUtil {

	private static long[] m_possiblePrimes;

	private static long m_primeUntil;

	public static boolean checkPrime(long startNumber) {
		if(startNumber == 2)
			return true;
		if(startNumber <= 0 || startNumber == 1 || startNumber % 2 == 0)
			return false;
		long lastNumber = (long) Math.sqrt(startNumber) + 1;
		for(long i = 3; i <= lastNumber; i += 2) {
			if(startNumber % i == 0)
				return false;
		}
		return true;
	}

	public static List<BigInteger> getPrimesUpUntil(long maxPrime) {
		List<BigInteger> possiblePrimes = new ArrayList<>();
		possiblePrimes.add(new BigInteger("2"));
		System.out.println("2 ");
		if(maxPrime % 2 != 0)
			maxPrime++;
		maxPrime /= 2;
		for(int i = 1; i < maxPrime; i++) {
			possiblePrimes.add(new BigInteger(i * 2 + 1 + ""));
		}

		boolean finished = false;
		int item = 1;
		while(!finished) {
			removeMultiples(possiblePrimes, possiblePrimes.get(item).longValue());
			System.out.println(possiblePrimes.get(item).longValue());
			if(item > Math.sqrt(possiblePrimes.get(possiblePrimes.size() - 1).longValue()))
				finished = true;
			item++;
		}
		return possiblePrimes;
	}

	private static void removeMultiples(List<BigInteger> possiblePrimes, long prime) {
		BigInteger largestValue = possiblePrimes.get(possiblePrimes.size() - 1);
		long calculateUntil = largestValue.intValue() / prime;
		int numberRemoved = 0;
		for(int i = (int) prime; i <= calculateUntil; i += 2) {
			BigInteger value = new BigInteger(i * prime + "");
			possiblePrimes.remove(value);
			numberRemoved++;
		}
		System.out.print(numberRemoved + " numbers removed for ");
	}

	public static long[] getPrimesUpUntilFast(long maxPrime) {
		m_primeUntil = maxPrime;
		if(maxPrime % 2 != 0)
			maxPrime++;
		maxPrime /= 2;
		m_possiblePrimes = new long[(int) maxPrime];
		m_possiblePrimes[0] = 2;
		for(int i = 1; i < maxPrime; i++) {
			m_possiblePrimes[i] = i * 2 + 1;
		}

		long calculateUntil = getMaxPossiblePrimes() - 1;
		for(int i = 1; i < calculateUntil; i++) {
			if(m_possiblePrimes[i] == 0)
				continue;
			removeNonPrimes(m_possiblePrimes[i]);
		}
		return m_possiblePrimes;
	}

	private static long getMaxPossiblePrimes() {
		return m_possiblePrimes.length;
	}

	private static void removeNonPrimes(long prime) {
		for(long i = prime * prime; i <= m_primeUntil; i += prime) {
			for(int j = 1; j < m_possiblePrimes.length; j++) {
				if(m_possiblePrimes[j] == i) {
					m_possiblePrimes[j] = 0;
					break;
				}
				if(m_possiblePrimes[j] > i) {
					break;
				}
			}
		}
	}
}
