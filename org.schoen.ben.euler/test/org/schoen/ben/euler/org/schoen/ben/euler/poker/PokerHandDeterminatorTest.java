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
        Assert.assertEquals("Value is 900", 900, pokerHandValue);
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
        Assert.assertEquals("Value is 810", 810, pokerHandValue);
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
        Assert.assertEquals("Value is 706", 706, pokerHandValue);
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
        Assert.assertEquals("Value is 602", 602, pokerHandValue);
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
        Assert.assertEquals("Value is 513", 513, pokerHandValue);
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
        Assert.assertEquals("Value is 413", 413, pokerHandValue);
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
        Assert.assertEquals("Value is 306", 306, pokerHandValue);
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
        Assert.assertEquals("Value is 211", 211, pokerHandValue);
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
        Assert.assertEquals("Value is 113", 113, pokerHandValue);
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
        Assert.assertEquals("Value is 11", 11, pokerHandValue);
        IPokerHandType pht = phd.getPokerHandType(ph);
        Assert.assertEquals("PokerHandType is PokerHandHighCard", PokerHandHighCard.class, pht.getClass());
    }
}
