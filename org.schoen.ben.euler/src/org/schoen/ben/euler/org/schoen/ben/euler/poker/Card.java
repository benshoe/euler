package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public class Card implements Comparable<Card> {
    private CardColor m_color;
    private CardValue m_value;

    public Card() {}

    public Card(CardColor color, CardValue value) {
        m_color = color;
        m_value = value;
    }

    /**
     *
     * @param card The string must be like: 5D for 5 of diamonds, and TC for 10 of clubs
     */
    public Card(String card) {
        m_value = getValue(card.charAt(0));
        m_color = getColor(card.charAt(1));
    }

    private CardValue getValue(char value) {
        switch (value) {
            case '2': return CardValue.TWO;
            case '3': return CardValue.THREE;
            case '4': return CardValue.FOUR;
            case '5': return CardValue.FIVE;
            case '6': return CardValue.SIX;
            case '7': return CardValue.SEVEN;
            case '8': return CardValue.EIGHT;
            case '9': return CardValue.NINE;
            case 'T': return CardValue.TEN;
            case 'J': return CardValue.JACK;
            case 'Q': return CardValue.QUEEN;
            case 'K': return CardValue.KING;
            case 'A': return CardValue.ACE;
            default: throw new IllegalArgumentException("There is no CardValue for char: " + value);
        }
    }

    private CardColor getColor(char color) {
        switch (color) {
            case 'D': return CardColor.DIAMONDS;
            case 'H': return CardColor.HEARTS;
            case 'S': return CardColor.SPADES;
            case 'C': return CardColor.CLUBS;
            default: throw new IllegalArgumentException("There is no CardColor that can be created by supplying: " + color);
        }
    }

    public void setColor(CardColor color) {
        m_color = color;
    }

    public void setCardValue(CardValue value) {
        m_value = value;
    }

    public CardValue getCardValue() {
        return m_value;
    }

    public int getValue() {
        return m_value.getValue();
    }

    public CardColor getColor() {
        return m_color;
    }

    @Override
    public int compareTo(Card o) {
        if(o == null)
            throw new NullPointerException("Card to compare to is null");
        if(o.getCardValue().getValue() == this.getCardValue().getValue())
            return 0;
        if(o.getCardValue().getValue() < this.getCardValue().getValue())
            return -1;
        return 1;
    }

}
