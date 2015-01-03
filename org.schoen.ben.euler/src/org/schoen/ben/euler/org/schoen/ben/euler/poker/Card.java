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
        if(o.getCardValue().getValue() == this.getCardValue().getValue())
            return 0;
        if(o.getCardValue().getValue() < this.getCardValue().getValue())
            return -1;
        return 1;
    }

}
