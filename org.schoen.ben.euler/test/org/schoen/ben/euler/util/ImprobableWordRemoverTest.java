package org.schoen.ben.euler.util;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ben on 08-01-17.
 */
public class ImprobableWordRemoverTest {

    @Test
    public void testWordRemover() {
        List<String> words = new ArrayList<>();
        words.add("ABDEFG");
        words.add("BDEFGHJ");
        words.add("");
        words.add("ABBA");

        ImprobableWordRemover remover = new ImprobableWordRemover();
        remover.removeImprobableWords(words);
        Assert.assertTrue(words.contains("ABDEFG"));
        Assert.assertFalse(words.contains("BDEFGHJ"));
        Assert.assertTrue(words.contains(""));
        Assert.assertTrue(words.contains("ABBA"));
    }

    @Test
    public void testRemoveImprobableLetterCombinations() {
        List<String> words = new ArrayList<>();
        words.add("ZR");
        words.add("ZP");
        words.add("BCDEFGJK");
        words.add("");
        words.add("ABBBA");
        words.add("BC");

        ImprobableWordRemover remover = new ImprobableWordRemover();
        remover.removeImprobableLetterCombinations(words);
        Assert.assertFalse(words.contains("ZR"));
        Assert.assertFalse(words.contains("ZP"));
        Assert.assertFalse(words.contains("BCDEFGJK"));
        Assert.assertTrue(words.contains(""));
        Assert.assertTrue(words.contains("ABBBA"));
        Assert.assertFalse(words.contains("BC"));

    }

}