package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerHandDeterminatorTest {

    @Test
    public void testRoyalFlush() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.CLUBS, CardValue.TEN));
        cards.add(new Card(CardSuit.CLUBS, CardValue.JACK));
        cards.add(new Card(CardSuit.CLUBS, CardValue.QUEEN));
        cards.add(new Card(CardSuit.CLUBS, CardValue.KING));
        cards.add(new Card(CardSuit.CLUBS, CardValue.ACE));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 9000000", 9000000, pokerHandValue);
    }

    @Test
    public void testStraightFlush() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.CLUBS, CardValue.SIX));
        cards.add(new Card(CardSuit.CLUBS, CardValue.SEVEN));
        cards.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        cards.add(new Card(CardSuit.CLUBS, CardValue.NINE));
        cards.add(new Card(CardSuit.CLUBS, CardValue.TEN));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 8000010", 8000010, pokerHandValue);
    }

    @Test
    public void testFourOfAKind() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.CLUBS, CardValue.SIX));
        cards.add(new Card(CardSuit.SPADES, CardValue.SIX));
        cards.add(new Card(CardSuit.HEARTS, CardValue.SIX));
        cards.add(new Card(CardSuit.DIAMONDS, CardValue.SIX));
        cards.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 7000006", 7000006, pokerHandValue);
    }

    @Test
    public void testFullHouse() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("2H"));
        cards.add(new Card("2D"));
        cards.add(new Card("QH"));
        cards.add(new Card("2C"));
        cards.add(new Card("QS"));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 6000002", 6000002, pokerHandValue);
    }

    @Test
    public void testFlush() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("3H"));
        cards.add(new Card("9H"));
        cards.add(new Card("2H"));
        cards.add(new Card("KH"));
        cards.add(new Card("QH"));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 5000013", 5000013, pokerHandValue);
    }

    @Test
    public void testThisIsHighCard() {
        // 14 SPADES, 13 SPADES, 7 SPADES, 6 SPADES, 2 CLUBS
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("AS"));
        cards.add(new Card("KS"));
        cards.add(new Card("7S"));
        cards.add(new Card("6S"));
        cards.add(new Card("2C"));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        IPokerHandType pht = phd.getPokerHandType(ph);
        Assert.assertEquals("This is a high card", PokerHandHighCard.class, pht.getClass());
    }

    @Test
    public void testStraight() {
        List<Card> straight = new ArrayList<>();
        straight.add(new Card("JC"));
        straight.add(new Card("KD"));
        straight.add(new Card("TH"));
        straight.add(new Card("9H"));
        straight.add(new Card("QS"));
        PokerHand ph = new PokerHand();
        ph.setCards(straight);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 4000013", 4000013, pokerHandValue);
    }

    @Test
    public void testThreeOfAKind() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.CLUBS, CardValue.SEVEN));
        cards.add(new Card(CardSuit.SPADES, CardValue.SIX));
        cards.add(new Card(CardSuit.HEARTS, CardValue.SIX));
        cards.add(new Card(CardSuit.DIAMONDS, CardValue.SIX));
        cards.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 3000006", 3000006, pokerHandValue);
    }

    @Test
    public void testTwoPairs() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.CLUBS, CardValue.JACK));
        cards.add(new Card(CardSuit.SPADES, CardValue.NINE));
        cards.add(new Card(CardSuit.HEARTS, CardValue.NINE));
        cards.add(new Card(CardSuit.DIAMONDS, CardValue.JACK));
        cards.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 2000011", 2000011, pokerHandValue);
    }

    @Test
    public void testOnePair() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.CLUBS, CardValue.JACK));
        cards.add(new Card(CardSuit.SPADES, CardValue.KING));
        cards.add(new Card(CardSuit.HEARTS, CardValue.NINE));
        cards.add(new Card(CardSuit.DIAMONDS, CardValue.KING));
        cards.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 1131198", 1131198, pokerHandValue);
    }

    @Test
    public void testHighCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardSuit.CLUBS, CardValue.JACK));
        cards.add(new Card(CardSuit.SPADES, CardValue.TEN));
        cards.add(new Card(CardSuit.HEARTS, CardValue.NINE));
        cards.add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
        cards.add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 120982", 120982, pokerHandValue);
        IPokerHandType pht = phd.getPokerHandType(ph);
        Assert.assertEquals("PokerHandType is PokerHandHighCard", PokerHandHighCard.class, pht.getClass());
    }

    @Test
    public void testHighCardTie() {
        List<Card> cardsP1 = new ArrayList<>();
        cardsP1.add(new Card(CardSuit.CLUBS, CardValue.SEVEN));
        cardsP1.add(new Card(CardSuit.DIAMONDS, CardValue.SIX));
        cardsP1.add(new Card(CardSuit.DIAMONDS, CardValue.FIVE));
        cardsP1.add(new Card(CardSuit.HEARTS, CardValue.TEN));
        cardsP1.add(new Card(CardSuit.SPADES, CardValue.THREE));
        PokerHand ph1 = new PokerHand();
        ph1.setCards(cardsP1);

        List<Card> cardsP2 = new ArrayList<>();
        cardsP2.add(new Card(CardSuit.CLUBS, CardValue.JACK));
        cardsP2.add(new Card(CardSuit.CLUBS, CardValue.FIVE));
        cardsP2.add(new Card(CardSuit.SPADES, CardValue.NINE));
        cardsP2.add(new Card(CardSuit.DIAMONDS, CardValue.THREE));
        cardsP2.add(new Card(CardSuit.HEARTS, CardValue.TWO));
        PokerHand ph2 = new PokerHand();
        ph2.setCards(cardsP2);

        PokerPlayer pokerPlayer1 = new PokerPlayer("Speler 1");
        pokerPlayer1.setPokerHand(ph1);
        PokerPlayer pokerPlayer2 = new PokerPlayer("Speler 2");
        pokerPlayer2.setPokerHand(ph2);
        PokerGame game = new PokerGame();
        game.addPlayer(pokerPlayer1);
        game.addPlayer(pokerPlayer2);
        PokerPlayer winner = game.getWinner();

        Assert.assertEquals("Speler 2 is the winner", pokerPlayer2, winner);
    }

    @Test
    public void testOnePairTie() {
        List<Card> cardsP1 = new ArrayList<>();
        cardsP1.add(new Card(CardSuit.CLUBS, CardValue.SEVEN));
        cardsP1.add(new Card(CardSuit.DIAMONDS, CardValue.SIX));
        cardsP1.add(new Card(CardSuit.DIAMONDS, CardValue.FIVE));
        cardsP1.add(new Card(CardSuit.HEARTS, CardValue.FIVE));
        cardsP1.add(new Card(CardSuit.SPADES, CardValue.THREE));
        PokerHand ph1 = new PokerHand();
        ph1.setCards(cardsP1);

        List<Card> cardsP2 = new ArrayList<>();
        cardsP2.add(new Card(CardSuit.CLUBS, CardValue.JACK));
        cardsP2.add(new Card(CardSuit.CLUBS, CardValue.FIVE));
        cardsP2.add(new Card(CardSuit.SPADES, CardValue.FIVE));
        cardsP2.add(new Card(CardSuit.DIAMONDS, CardValue.THREE));
        cardsP2.add(new Card(CardSuit.HEARTS, CardValue.TWO));
        PokerHand ph2 = new PokerHand();
        ph2.setCards(cardsP2);

        PokerPlayer pokerPlayer1 = new PokerPlayer("Speler 1");
        pokerPlayer1.setPokerHand(ph1);
        PokerPlayer pokerPlayer2 = new PokerPlayer("Speler 2");
        pokerPlayer2.setPokerHand(ph2);
        PokerGame game = new PokerGame();
        game.addPlayer(pokerPlayer1);
        game.addPlayer(pokerPlayer2);
        PokerPlayer winner = game.getWinner();

        Assert.assertEquals("Speler 2 is the winner", pokerPlayer2, winner);
    }
}
