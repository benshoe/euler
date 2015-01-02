package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public class PokerPlayer {
    private PokerHand m_pokerHand;

    public void setPokerHand(PokerHand pokerHand) {
        m_pokerHand = pokerHand;
    }

    public PokerHand getPokerHand() {
        return m_pokerHand;
    }
}
