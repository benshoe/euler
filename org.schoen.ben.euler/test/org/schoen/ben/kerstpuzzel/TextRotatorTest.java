package org.schoen.ben.kerstpuzzel;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by ben on 16-12-16.
 */
public class TextRotatorTest {

    TextRotator m_textRotator = new TextRotator();

    @Test
    public void rotateText() throws Exception {
        String text = "abc";
        String newText = m_textRotator.rotateText(text, 1);
        Assert.assertEquals("bcd", newText);
    }

    @Test
    public void rotateText2Pos() throws Exception {
        String text = "abc";
        Assert.assertEquals("cde", m_textRotator.rotateText(text, 2));
    }

    @Test
    public void rotateTextAfterZ() throws Exception {
        String text = "xyz";
        Assert.assertEquals("yza", m_textRotator.rotateText(text, 1));
    }

    @Test
    public void rotateTextWithSpace() throws Exception {
        String text = "xzza hal";
        Assert.assertEquals("yaab ibm", m_textRotator.rotateText(text, 1));
    }

    @Test
    public void rotateTextWithMoreThan26() {
        String text = "xyz";
        Assert.assertEquals("yza", m_textRotator.rotateText(text, 27));
    }

    @Test
    public void rotateTextBelowLetterA() {
        String text = "abc";
        Assert.assertEquals("zab", m_textRotator.rotateText(text, -1));
    }

    @Test
    public void rotateTextWithSpecialLetter() {
        String text = "ab,c";
        Assert.assertEquals("za,b", m_textRotator.rotateText(text, -1));
    }

    @Test
    public void rotateTextWithCapitals() {
        String text = "HAL";
        Assert.assertEquals("IBM", m_textRotator.rotateText(text, 1));
    }
}
