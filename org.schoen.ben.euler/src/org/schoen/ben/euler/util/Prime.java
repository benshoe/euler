package org.schoen.ben.euler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bens on 12/23/14.
 */
public class Prime {
	final private BigInteger m_prime;

	private List<PrimeFamily> m_primeFamilyList = new ArrayList<>();

	public Prime(BigInteger prime) {
		m_prime = prime;
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

	private void setPrimeFamilies(List<PrimeFamily> primeFamilyList) {
		m_primeFamilyList = primeFamilyList;
	}
}
