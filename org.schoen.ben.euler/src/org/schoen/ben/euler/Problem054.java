package org.schoen.ben.euler;

import org.schoen.ben.euler.org.schoen.ben.euler.poker.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public class Problem054 extends AbstractEulerProblem {

    public Problem054(String answer) {
        super(answer);
    }

    @Override
    public void run() {
        int answer = 0;
        PokerGame game = new PokerGame();

        PokerPlayer player1 = new PokerPlayer("Player1");
        PokerPlayer player2 = new PokerPlayer("Player2");
        game.addPlayer(player1);
        game.addPlayer(player2);
        PokerHand ph1 = new PokerHand();
        player1.setPokerHand(ph1);
        PokerHand ph2 = new PokerHand();
        player2.setPokerHand(ph2);

        // voor alle sets van kaarten
        List<Card> cards = new ArrayList<>();
        Card c1 = new Card();
        c1.setColor(CardColor.CLUBS);
        c1.setCardValue(CardValue.ACE);
        cards.add(c1);
        ph1.setCards(cards);
        player1.setPokerHand(ph1);
        if (game.getWinner().equals(player1)) {
            answer++;
        }
        setAnswer(String.valueOf(answer));
    }

    @Override
    public String getProblemName() {
        return "Problem 54: Poker hands. Which player wins most games?";
    }
}
