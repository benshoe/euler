package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/3/15.
 */
public class PokerHandFourOfAKind implements IPokerHandType {
    private static final int VALUE = 700;
    private int m_extraValue;

    public PokerHandFourOfAKind(List<Card> cards) {
        CardValue commonCardValue = cards.get(0).getCardValue();
        for (int i = 1; i < cards.size(); i++) {
            if(cards.get(i).getCardValue() == commonCardValue || cards.get(i + 1).getCardValue() == commonCardValue) {
                m_extraValue = commonCardValue.getValue();
                break;
            }
            m_extraValue = cards.get(i).getValue();
            break;
        }
    }

    @Override
    public int getValue() {
        return VALUE + m_extraValue;
    }

    @Override
    public String getTypeName() {
        return "Four of a kind";
    }
}
