package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/10/15.
 */
public class PokerHandThreeOfAKind implements IPokerHandType {

    private static final int VALUE = 300;
    private int m_value;

    public PokerHandThreeOfAKind(List<Card> cards) {
        Map<Integer, List<Card>> cardMap = cards.stream() //
                .collect(Collectors.groupingBy(c -> c.getValue()));
        for(List<Card> cardList: cardMap.values()) {
            if(cardList.size() == 3)
                m_value = cardList.get(0).getValue();
        }
    }

    @Override
    public int getValue() {
        return VALUE + m_value;
    }

    @Override
    public String getTypeName() {
        return "Three of a kind";
    }
}
