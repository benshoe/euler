package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/10/15.
 */
public class PokerHandStraight implements IPokerHandType {
    private static final int VALUE = 400;
    private final int m_value;

    public PokerHandStraight(int value) {
        m_value = value;
    }

    @Override
    public int getValue() {
        return VALUE + m_value;
    }

    @Override
    public String getTypeName() {
        return "Straight";
    }
}
