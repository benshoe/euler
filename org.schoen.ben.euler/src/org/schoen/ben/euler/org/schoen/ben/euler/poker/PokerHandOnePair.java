package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/11/15.
 */
public class PokerHandOnePair implements IPokerHandType {
    private static final int VALUE = 1000000;
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
        int tieBreakerValue = 0;

        int multiplier = 2;
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getValue() == m_value) {
                continue;
            }
            tieBreakerValue += cards.get(i).getValue() * Math.pow(10, multiplier);
            multiplier--;
        }
        m_value *= 10000;
        m_value += tieBreakerValue;
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
