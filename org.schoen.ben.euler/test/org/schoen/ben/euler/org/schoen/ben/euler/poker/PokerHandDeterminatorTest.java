package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PokerHandDeterminatorTest {

    @Test
    public void testGetRoyalFlushValue() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardColor.CLUBS, CardValue.TEN));
        cards.add(new Card(CardColor.CLUBS, CardValue.JACK));
        cards.add(new Card(CardColor.CLUBS, CardValue.QUEEN));
        cards.add(new Card(CardColor.CLUBS, CardValue.KING));
        cards.add(new Card(CardColor.CLUBS, CardValue.ACE));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 900", 900, pokerHandValue);
    }

    @Test
    public void testGetStraightFlushValue() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardColor.CLUBS, CardValue.SIX));
        cards.add(new Card(CardColor.CLUBS, CardValue.SEVEN));
        cards.add(new Card(CardColor.CLUBS, CardValue.EIGHT));
        cards.add(new Card(CardColor.CLUBS, CardValue.NINE));
        cards.add(new Card(CardColor.CLUBS, CardValue.TEN));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 810", 810, pokerHandValue);
    }

    @Test
    public void testFourOfAKindValue() throws Exception {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardColor.CLUBS, CardValue.SIX));
        cards.add(new Card(CardColor.SPADES, CardValue.SIX));
        cards.add(new Card(CardColor.HEARTS, CardValue.SIX));
        cards.add(new Card(CardColor.DIAMONDS, CardValue.SIX));
        cards.add(new Card(CardColor.CLUBS, CardValue.EIGHT));
        PokerHand ph = new PokerHand();
        ph.setCards(cards);

        PokerHandDeterminator phd = new PokerHandDeterminator();
        int pokerHandValue = phd.getPokerHandValue(ph);
        Assert.assertEquals("Value is 706", 706, pokerHandValue);
    }
}
