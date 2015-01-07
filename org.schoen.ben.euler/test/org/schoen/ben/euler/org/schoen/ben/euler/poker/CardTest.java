package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTest {

    @Test
    public void testOrderingCards() {
        Card cardC5 = new Card(CardSuit.CLUBS, CardValue.FIVE);
        Card cardC7 = new Card(CardSuit.CLUBS, CardValue.SEVEN);
        Card cardH5 = new Card(CardSuit.HEARTS, CardValue.FIVE);
        Card cardCT = new Card(CardSuit.CLUBS, CardValue.TEN);
        Card cardST = new Card(CardSuit.SPADES, CardValue.TEN);
        List<Card> cards = new ArrayList<>();
        cards.add(cardC5);
        cards.add(cardST);
        cards.add(cardH5);
        cards.add(cardCT);
        cards.add(cardC7);
        Collections.sort(cards);
        Assert.assertEquals("The first card has value 10", cards.get(0).getValue(), 10);
        Assert.assertEquals("The second card has value 10", cards.get(1).getValue(), 10);
        Assert.assertEquals("The third card has value 7", cards.get(2), cardC7);
        Assert.assertEquals("The fourth card has value 5", cards.get(3).getValue(), 5);
        Assert.assertEquals("The last card has value 5", cards.get(4).getValue(), 5);
    }

    @Test
    public void testCardCreation() {
        Card card5D = new Card("5D");
        Assert.assertEquals("Value is 5", CardValue.FIVE, card5D.getCardValue());
        Assert.assertEquals("Suit is diamonds", CardSuit.DIAMONDS, card5D.getSuit());

        Card cardAC = new Card("AC");
        Assert.assertEquals("Value is ace", CardValue.ACE, cardAC.getCardValue());
        Assert.assertEquals("Suit is clubs", CardSuit.CLUBS, cardAC.getSuit());

        Card card2S = new Card("2S");
        Assert.assertEquals("Value is 2", CardValue.TWO, card2S.getCardValue());
        Assert.assertEquals("Suit is spades", CardSuit.SPADES, card2S.getSuit());

        Card cardQH = new Card("QH");
        Assert.assertEquals("Value is queen", CardValue.QUEEN, cardQH.getCardValue());
        Assert.assertEquals("Suit is hearts", CardSuit.HEARTS, cardQH.getSuit());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalCard() {
        Card illegalCard = new Card("1C");
        Assert.fail("This code should not be reached.");
    }
}
