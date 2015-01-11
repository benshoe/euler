package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/11/15.
 */
public class PokerHandOnePair implements IPokerHandType {
    private static final int VALUE = 100;
    private int m_value;

    public PokerHandOnePair(List<Card> cards) {
        int firstValue = cards.get(0).getValue();
        for (int i = 1; i < cards.size(); i++) {
            int secondValue = cards.get(i).getValue();
            if (firstValue == secondValue) {
                m_value = firstValue;
                break;
            } else
                firstValue = secondValue;
        }
    }

    @Override
    public int getValue() {
        return VALUE + m_value;
    }

    @Override
    public String getTypeName() {
        return "One pair";
    }
}
