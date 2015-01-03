package org.schoen.ben.euler.org.schoen.ben.euler.poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardTest {

    @Test
    public void testOrderingCards() {
        Card cardC5 = new Card(CardColor.CLUBS, CardValue.FIVE);
        Card cardC7 = new Card(CardColor.CLUBS, CardValue.SEVEN);
        Card cardH5 = new Card(CardColor.HEARTS, CardValue.FIVE);
        Card cardCT = new Card(CardColor.CLUBS, CardValue.TEN);
        Card cardST = new Card(CardColor.SPADES, CardValue.TEN);
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
}
