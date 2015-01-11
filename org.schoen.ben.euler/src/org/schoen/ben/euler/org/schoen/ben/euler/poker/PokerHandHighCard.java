package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/11/15.
 */
public class PokerHandHighCard implements IPokerHandType {
    private int m_value;

    public PokerHandHighCard(List<Card> cards) {
        m_value = cards.get(0).getValue();
    }

    @Override
    public int getValue() {
        return m_value;
    }
}
