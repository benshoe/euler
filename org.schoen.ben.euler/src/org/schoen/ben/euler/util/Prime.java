package org.schoen.ben.euler.util;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 */
public class Prime {

	private Map<PrimeFamily, List<Prime>> m_primeFamilyList = new HashMap<>();

	private BigInteger m_prime;

	public Prime(BigInteger prime) {
		m_prime = prime;
		m_primeFamilyList = PrimeFamilyCalculator.getPrimeFamilies();
	}

	public Prime(long prime) {
		this(BigInteger.valueOf(prime));
	}

	public Prime(int prime) {
		this(BigInteger.valueOf(prime));
	}

	public Map<PrimeFamily, List<Prime>> getPrimeFamilies() {
		return m_primeFamilyList;
	}

	@Override
	public String toString() {
		return m_prime.toString();
	}
}
