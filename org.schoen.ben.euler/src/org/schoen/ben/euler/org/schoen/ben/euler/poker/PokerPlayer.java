package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public class PokerPlayer {

    private final String m_playerName;
    private PokerHand m_pokerHand;

    public PokerPlayer(String player) {
        m_playerName = player;
    }

    public String getPlayerName() {
        return m_playerName;
    }

    public void setPokerHand(PokerHand pokerHand) {
        m_pokerHand = pokerHand;
    }

    public PokerHand getPokerHand() {
        return m_pokerHand;
    }
}
