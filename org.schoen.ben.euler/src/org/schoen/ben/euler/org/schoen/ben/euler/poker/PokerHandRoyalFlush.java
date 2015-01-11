package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/3/15.
 */
public class PokerHandRoyalFlush implements IPokerHandType {
    private static final int VALUE = 9000000;

    @Override
    public int getValue() {
        return VALUE;
    }

    @Override
    public String getTypeName() {
        return "Royal flush";
    }
}
