package org.schoen.ben.euler.util;

import junit.framework.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by ben on 24-12-16.
 */
public class CombinationUtilTest {

    @Test
    public void testCombinationCount() {
        int combinations = CombinationUtil.findCombinationsCount(8, new int[]{2, 4});
        Assert.assertEquals(3, combinations);
    }

    @Test
    public void testCombinations() {
        List<List<Integer>> combinationList = CombinationUtil.findCombinations(8, new int[]{2, 4});
        List<Integer> list1 = new ArrayList<>();
        list1.add(Integer.valueOf("2"));
        list1.add(Integer.valueOf("2"));
        list1.add(Integer.valueOf("2"));
        list1.add(Integer.valueOf("2"));

        List<Integer> list2 = new ArrayList<>();
        list2.add(Integer.valueOf("2"));
        list2.add(Integer.valueOf("2"));
        list2.add(Integer.valueOf("4"));

        List<Integer> list3 = new ArrayList<>();
        list3.add(Integer.valueOf("4"));
        list3.add(Integer.valueOf("4"));

        for(List<Integer> combination : combinationList) {
            System.out.println("combination = " + combination);
        }

        //Assert.assertTrue(combinationList.contains(list1));
        //Assert.assertTrue(combinationList.contains(list2));
        //Assert.assertTrue(combinationList.contains(list3));
    }

}
