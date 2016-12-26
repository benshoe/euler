package org.schoen.ben.euler.util;

/**
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since 12/26/16.
 */
public enum ALPHABET {
	A(1), B(2), C(3),
	D(4), E(5), F(6),
	G(7), H(8), I(9),
	J(10), K(11), L(12),
	M(13), N(14), O(15),
	P(16), Q(17), R(18),
	S(19), T(20), U(21),
	V(22), W(23), X(24),
	Y(25), Z(26);

	private int getValue() {
		return m_value;
	}

	private final int m_value;

	ALPHABET(int value) {
		m_value = value;
	}

	public static ALPHABET getLetter(int value) {
		for(ALPHABET alphabet : ALPHABET.values()) {
			if(alphabet.getValue() == value) {
				return alphabet;
			}
		}
		throw new IllegalStateException("Letter not found for value: " + value);
	}
}
