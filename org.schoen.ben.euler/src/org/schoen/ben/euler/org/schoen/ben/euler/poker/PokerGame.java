package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public class PokerGame {
    private List<PokerPlayer> m_players;
    private PokerPlayer m_winner;

    public void addPlayer(PokerPlayer player) {
        if (m_players == null)
            m_players = new ArrayList<>();
        m_players.add(player);
    }

    public PokerPlayer getWinner() {
        return determineWinner();
    }

    private PokerPlayer determineWinner() {
        PokerPlayer winner = new PokerPlayer("Undefined");

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int maxValue = 0;
        for(PokerPlayer pp: m_players) {
            int value = phd.getPokerHandValue(pp.getPokerHand());
            if(value == maxValue) {
                throw new IllegalStateException("We should not have a tie");
            } else if(value > maxValue) {
                maxValue = value;
                winner = pp;
            }
        }

        return winner;
    }
}
