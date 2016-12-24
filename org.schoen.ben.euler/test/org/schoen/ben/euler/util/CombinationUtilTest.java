package org.schoen.ben.euler.util;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ben on 24-12-16.
 */
public class CombinationUtilTest {

    @Test
    public void testCombinationCount() {
        int combinations = CombinationUtil.findCombinationsCount(8, new int[]{2, 4});
        Assert.assertEquals(3, combinations);
        List<List<Integer>> combinationList = CombinationUtil.findCombinations(8, new int[]{2, 4});

    }

}