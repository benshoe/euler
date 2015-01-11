package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/11/15.
 */
public class PokerHandHighCard implements IPokerHandType {
    private int m_value;

    public PokerHandHighCard(List<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            m_value += cards.get(i).getValue() * Math.pow(10, cards.size() - 1 - i);
        }
    }

    @Override
    public int getValue() {
        return m_value;
    }

    @Override
    public String getTypeName() {
        return "High card";
    }
}
