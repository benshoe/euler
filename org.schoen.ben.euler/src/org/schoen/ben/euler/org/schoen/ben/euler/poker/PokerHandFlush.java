package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/7/15.
 */
public class PokerHandFlush implements IPokerHandType {
    private static final int VALUE = 500;
    private int m_lowestCardValue;

    public PokerHandFlush(int lowestCard) {
        m_lowestCardValue = lowestCard;
    }

    @Override
    public int getValue() {
        return VALUE + m_lowestCardValue;
    }
}
