package org.schoen.ben.euler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 */
public class Prime {

	private List<PrimeFamily> m_primeFamilyList = new ArrayList<>();

	public Prime(BigInteger prime) {
		m_primeFamilyList = PrimeFamilyCalculator.getPrimeFamilies(prime);
	}

	public Prime(long prime) {
		this(BigInteger.valueOf(prime));
	}

	public Prime(int prime) {
		this(BigInteger.valueOf(prime));
	}

	public List<PrimeFamily> getPrimeFamilies() {
		return m_primeFamilyList;
	}
}
