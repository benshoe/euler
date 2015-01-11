package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/3/15.
 */
public final class PokerHandStraightFlush implements IPokerHandType {
    private static final int VALUE = 800;
    private int m_highestValue;

    public PokerHandStraightFlush(CardValue highestCardValue) {
        m_highestValue = highestCardValue.getValue();
    }

    @Override
    public int getValue() {
        return VALUE + m_highestValue;
    }

    @Override
    public String getTypeName() {
        return "Straight flush";
    }
}
