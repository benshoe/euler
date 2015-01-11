package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/11/15.
 */
public class PokerHandTwoPairs implements IPokerHandType {
    private static final int VALUE = 200;
    private int m_value;

    public PokerHandTwoPairs(List<Card> cards) {
        Map<Integer, List<Card>> cardMap = cards.stream() //
                .collect(Collectors.groupingBy(c -> c.getValue()));
        int minValue = 100;
        for(List<Card> cardList: cardMap.values()) {
            if(cardList.size() == 2) {
                if(cardList.get(0).getValue() < minValue)
                    minValue = cardList.get(0).getValue();
            }
        }
        m_value = minValue;
    }

    @Override
    public int getValue() {
        return VALUE + m_value;
    }
}
