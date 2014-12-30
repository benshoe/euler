package org.schoen.ben.euler.util;

import java.util.Arrays;

/**
 * Created by Ben Schoen on 12/23/14.
 */
public class PrimeFamily {

	private int m_length; // length of the prime (e.g. 53347 has length 5 and 13 has length 2)
	private int m_common; // the number that is equal in the positions (e.g. 53347 would have 3 and 56647 would have 6 as common
	// In 13, 23, 43, and 83 the m_common would be 1, 2, 4, and 8
	private int m_numberLeft; // the number that is equal in the family (e.g. 53347 and 56647 have 547 as the numberLeft)
	private int m_numberDuplicates; // the number of duplicates found for the m_common value
	private Integer[] m_positions; // the positions that have equal numbers (e.g. 53347 has positions [1,2] and 55467 [0,1]

	public PrimeFamily(int length, int common, int numberLeft, Integer[] positions) {
		m_length = length;
		m_common = common;
		m_numberDuplicates = positions.length;
		m_numberLeft = numberLeft;
		m_positions = positions;
	}

	public PrimeFamily() {
	}

	public int getLength() {
		return m_length;
	}

	public void setLength(int length) {
		m_length = length;
	}

	public int getCommon() {
		return m_common;
	}

	public void setCommon(int common) {
		m_common = common;
	}

	public int getNumberDuplicates() {
		return m_numberDuplicates;
	}

	public void setNumberDuplicates(int numberDuplicates) {
		m_numberDuplicates = numberDuplicates;
	}

	public int getNumberLeft() {
		return m_numberLeft;
	}

	public void setNumberLeft(int numberLeft) {
		m_numberLeft = numberLeft;
	}

	public Integer[] getPositions() {
		return m_positions;
	}

	public void setPositions(Integer[] positions) {
		m_positions = positions;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PrimeFamily)) return false;
		PrimeFamily other = (PrimeFamily) o;
		if (other.getLength() != this.getLength())
			return false;
		if (!Arrays.equals(other.getPositions(), this.getPositions()))
			return false;
		if(other.getNumberLeft() != this.getNumberLeft())
			return false;
		if(other.getNumberDuplicates() != this.getNumberDuplicates())
			return false;
		return true;
	}

	@Override
	public int hashCode () {
		int hash = 31;
//		if(m_common != 0) hash *=m_common;
		if(m_numberDuplicates !=0) hash *= m_numberDuplicates;
		if(m_length !=0) hash *= m_length;
		if(m_positions.length !=0) hash *= m_positions.length;
		return hash;
	}
}
