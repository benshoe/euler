package org.schoen.ben.euler.org.schoen.ben.euler.poker;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/2/15.
 */
public enum CardColor {
    DIAMONDS("D"), CLUBS("C"), SPADES("S"), HEARTS("H");

    private final String m_color;

    CardColor(String color) {
        m_color = color;
    }

    public String getColor() {
        return m_color;
    }

}
