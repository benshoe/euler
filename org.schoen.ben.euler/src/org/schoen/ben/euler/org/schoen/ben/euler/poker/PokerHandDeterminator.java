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

    public IPokerHandType getPokerHandType(PokerHand pokerHand) {
        List<Card> cards = pokerHand.getCards();
        Collections.sort(cards);
        if (cardsHaveSameSuit(cards)) {
            if (cardsAreTenThroughAce(cards)) {
                return new PokerHandRoyalFlush();
            }
            if (cardsAreInARow(cards)) {
                return new PokerHandStraightFlush(cards.get(0).getCardValue());
            }
        }
        if(moreOfAKind(cards, 4)) {
            return new PokerHandFourOfAKind(cards);
        }
        if(fullHouse(cards)) {
            return new PokerHandFullHouse(cards);
        }
        if(allSameSuit(cards)) {
            return new PokerHandFlush(cards.get(0).getValue());
        }
        if(cardsAreInARow(cards)) {
            return new PokerHandStraight(cards.get(0).getValue());
        }
        if(moreOfAKind(cards, 3)) {
            return new PokerHandThreeOfAKind(cards);
        }
        if(twoPairs(cards)) {
            return new PokerHandTwoPairs(cards);
        }
        if(onePair(cards)) {
            return new PokerHandOnePair(cards);
        }
        return new PokerHandHighCard(cards);

    }

    public int getPokerHandValue(PokerHand pokerHand) {
        return getPokerHandType(pokerHand).getValue();
    }

    private boolean onePair(List<Card> cards) {
        Map<Integer, List<Card>> cardMap = cards.stream() //
                .collect(Collectors.groupingBy(c -> c.getValue()));
        return cardMap.size() == 4;
    }

    private boolean twoPairs(List<Card> cards) {
        Map<Integer, List<Card>> cardMap = cards.stream() //
                .collect(Collectors.groupingBy(c -> c.getValue()));
        return cardMap.size() == 3;
    }

    private boolean allSameSuit(List<Card> cards) {
        CardSuit cc = cards.get(0).getSuit();
        for (int i = 1; i < 4; i++) {
            if(cards.get(i).getSuit() != cc)
                return false;
        }
        return true;
    }

    private boolean fullHouse(List<Card> cards) {
        Map<Integer, List<Card>> cardMap = cards.stream() //
                .collect(Collectors.groupingBy(c -> c.getValue()));
        if(cardMap.values().size() == 2) {
            // We hebben al gecontroleerd of er sprake is van four of a kind.
            //  Aangezien dat niet zo is, moet het wel een compbinatie zijn van 2 om 3 gelijken dus een full house.
            return true;
        }
        return false;
    }

    private boolean moreOfAKind(List<Card> cards, int sameOfAKind) {
        Map<Integer, List<Card>> cardMap = cards.stream() //
         .collect(Collectors.groupingBy(c -> c.getValue()));
        for(List<Card> cardList: cardMap.values()) {
            if(cardList.size() == sameOfAKind)
                return true;
        }
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

    private boolean cardsHaveSameSuit(List<Card> cards) {
        CardSuit cc = cards.get(0).getSuit();
        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i).getSuit() != cc)
                return false;
        }
        return true;
    }
}
