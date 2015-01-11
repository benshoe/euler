package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/7/15.
 */
public class PokerHandFlush implements IPokerHandType {
    private static final int VALUE = 5000000;
    private int m_value;

    public PokerHandFlush(int lowestCard) {
        m_value = lowestCard;
    }

    @Override
    public int getValue() {
        return VALUE + m_value;
    }

    @Override
    public String getTypeName() {
        return "Flush";
    }
}
