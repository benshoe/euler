package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public class Card {
    private CardColor m_color;
    private CardValue m_value;

    public void setColor(CardColor color) {
        m_color = color;
    }

    public void setValue(CardValue value) {
        m_value = value;
    }
}
