package org.schoen.ben.euler.util;

/**
 * Created by bens on 12/23/14.
 */
public class PrimeFamily {
	private int m_length; // length of the prime (e.g. 53347 has length 5 and 13 has length 2)
	private int m_common; // the number that is equal in the positions (e.g. 53347 would have 3 and 56647 would have 6 as common
	private int m_numberLeft; // the number that is equal in the family (e.g. 53347 and 56647 have 547 as the numberLeft)
	private int[] m_positions; // the positions that have equal numbers (e.g. 53347 has positions [1,2] and 55467 [0,1]

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

	public int getNumberLeft() {
		return m_numberLeft;
	}

	public void setNumberLeft(int numberLeft) {
		m_numberLeft = numberLeft;
	}


	public int[] getPositions() {
		return m_positions;
	}

	public void setPositions(int[] positions) {
		m_positions = positions;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PrimeFamily)) return false;
		PrimeFamily other = (PrimeFamily) o;
		if (other.getLength() != this.getLength())
			return false;
		if (other.getPositions() != this.getPositions())
			return false;
		if(other.getNumberLeft() != this.getNumberLeft())
			return false;
		return true;
	}
}
