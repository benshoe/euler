package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public class PokerHand {
    private List<Card> m_cards;

    public void setCards(List<Card> cards) {
        m_cards = cards;
    }

    public List<Card> getCards() {
        return m_cards;
    }

    public void printCards() {
        Collections.sort(m_cards);
        for(Card card: m_cards) {
            System.out.print(card + ", ");
        }
    }
}
