package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public enum CardValue {

    TWO(2), THREE(3),

    FOUR(4),FIVE(5),

    SIX(6),SEVEN(7),

    EIGHT(8), NINE(9),

    TEN(10), JACK(11),

    QUEEN(12), KING(13),

    ACE(14);

    private int m_value;

    CardValue(int i) {
        m_value = i;
    }

    public int getValue() {
        return m_value;
    }
}
