package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/7/15.
 */
public class PokerHandFullHouse implements IPokerHandType {
    private static final int VALUE = 600;
    private int m_extraValue;

    public PokerHandFullHouse(List<Card> cards) {
        Map<Integer, List<Card>> cardMap = cards.stream().collect(Collectors.groupingBy(c -> c.getValue()));
        int maxValue = 0;
        for(List<Card> cardList: cardMap.values()) {
            if (cardList.size() == 3) {
                maxValue = cardList.get(0).getValue();
                break;
            }
        }
        m_extraValue = maxValue;
    }

    @Override
    public int getValue() {
        return VALUE + m_extraValue;
    }

    @Override
    public String getTypeName() {
        return "Full house";
    }
}
