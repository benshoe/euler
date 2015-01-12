package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public enum CardSuit {
    DIAMONDS("D"), CLUBS("C"), SPADES("S"), HEARTS("H");

    private final String m_suit;

    CardSuit(String suit) {
        m_suit = suit;
    }

    public String getSuit() {
        return m_suit;
    }

}
