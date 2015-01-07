package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/3/15.
 */
public final class PokerHandDeterminator {

    public int getPokerHandValue(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        Collections.sort(cards);
        if (cardsHaveSameColor(cards)) {
            if (cardsAreTenThroughAce(cards)) {
                IPokerHandType pht = new PokerHandRoyalFlush();
                return pht.getValue();
            }
            if (cardsAreInARow(cards)) {
                IPokerHandType pht = new PokerHandStraightFlush(cards.get(0).getCardValue());
                return pht.getValue();
            }
        }
        if(fourOfAKind(cards)) {
            IPokerHandType pht = new PokerHandfourOfAKind(cards);
            return pht.getValue();
        }
        return -1;
    }

    private boolean fourOfAKind(List<Card> cards) {
        Map<Integer, List<Card>> cardMap = cards.stream() //
         .collect(Collectors.groupingBy(c -> c.getValue()));
        for(List<Card> cardList: cardMap.values()) {
            if(cardList.size() == 4)
                return true;
        }
        System.out.println(cardMap);

        return false;
    }

    private boolean cardsAreInARow(List<Card> cards) {
        CardValue cv = cards.get(0).getCardValue();
        for (int i = 1; i < cards.size(); i++) {
            if(cards.get(i).getValue() != cv.getValue() - i)
                return false;
        }
        return true;
    }

    private boolean cardsAreTenThroughAce(List<Card> cards) {
        CardValue ten = CardValue.ACE;
        for (int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getValue() != ten.getValue() - i)
                return false;
        }
        return true;
    }

    private boolean cardsHaveSameColor(List<Card> cards) {
        CardColor cc = cards.get(0).getColor();
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getColor() != cc)
                return false;
        }
        return true;
    }
}
