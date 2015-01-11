package org.schoen.ben.euler;

import org.schoen.ben.euler.org.schoen.ben.euler.poker.*;
import org.schoen.ben.euler.util.FileUtil;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public class Problem054 extends AbstractEulerProblem {

    private static final String REGEXP = "\\W+"; // for splitting into words

    public Problem054(String answer) {
        super(answer);
    }

    @Override
    public void run() {
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
        BufferedReader bufferedReader = FileUtil.readFile("File054.txt");
        List<String> dealtCards = bufferedReader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).collect(Collectors.toList());

        int winsP1 = 0;
        int counter = 0;
        while(counter < 10000) {
            List<Card> cardsP1 = new ArrayList<>();
            List<Card> cardsP2 = new ArrayList<>();
            ph1.setCards(Collections.EMPTY_LIST);
            ph2.setCards(Collections.EMPTY_LIST);
            for (int i = 0; i < 5; i++) {
                cardsP1.add(new Card(dealtCards.get(counter)));
                counter++;
            }
            ph1.setCards(cardsP1);
            for (int j = 0; j < 5; j++) {
                cardsP2.add(new Card(dealtCards.get(counter)));
                counter++;
            }
            ph2.setCards(cardsP2);
            if(player1 == game.getWinner()) {
                winsP1++;
            }
        }

        System.out.println("Aantal spelletjes is: " + counter/10);

        setAnswer(String.valueOf(winsP1));
    }

    private void printPokerhand(PokerHand pokerHand, PokerHandDeterminator pokerHandDeterminator, String player) {
        System.out.print(player);
        pokerHand.printCards();
        System.out.println(": " + pokerHandDeterminator.getPokerHandType(pokerHand).getTypeName() + " met waarde: " + pokerHandDeterminator.getPokerHandValue(pokerHand));
    }

    @Override
    public String getProblemName() {
        return "Problem 54: Poker hands. Which player wins most games?";
    }
}
