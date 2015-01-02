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
        if(m_winner == null) {
            m_winner = determineWinner();
        }
        return m_winner;
    }

    private PokerPlayer determineWinner() {
        PokerPlayer winner;

        return m_players.get(0);
    }
}
