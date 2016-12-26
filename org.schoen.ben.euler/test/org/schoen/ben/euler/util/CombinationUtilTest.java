package org.schoen.ben.euler.util;

import org.junit.*;
import org.schoen.ben.kerstpuzzel.*;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by ben on 24-12-16.
 */
public class CombinationUtilTest {

    @Test
    public void testCombinationCount() {
        int combinations = CombinationUtil.findCombinationsCount(8, new int[]{2, 4});
        assertEquals(3, combinations);
    }

    @Test
    public void test1Cent() {
        int answer = CombinationUtil.findCombinationsCount(200, new int[]{1});
        assertEquals(1, answer);
    }

    @Test
    public void test5Cent() {
        int answer = CombinationUtil.findCombinationsCount(200, new int[]{5});
        assertEquals(1, answer);
    }

    @Test
    public void test50And100Cent() {
        int answer = CombinationUtil.findCombinationsCount(250, new int[]{50, 100});
        assertEquals(3, answer);
    }

    @Test
    public void testCombinationsSum() {
        Set<List<Integer>> combinationList = CombinationUtil.findCombinations(250, new int[]{50, 100});
        for(List<Integer> combination : combinationList) {
            System.out.println("combination = " + combination);
        }
    }

    @Test
	public void printAllTest() {
		CombinationUtil.printAll(0, new int[]{50,100}, 250, new int[]{50, 100});
    }

	@Test
    public void printAll200CentTest() {
        CombinationUtil.printAll(0,  new int[]{1, 2, 5, 10, 20, 50, 100, 200}, 200, new int[]{1, 2, 5, 10, 20, 50, 100, 200});
    }

	@Test
	public void test200Cent() {
		int answer = CombinationUtil.findCombinationsCount(200, new int[]{1, 2, 5, 10, 20, 50, 100, 200});
		assertEquals(73682, answer);
	}

    @Test
    public void testCombinations() {
        Set<List<Integer>> combinationList = CombinationUtil.findCombinations(8, new int[]{2, 4});
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

        assertTrue(combinationList.contains(list1));
        assertTrue(combinationList.contains(list3));
        assertTrue(combinationList.contains(list2));
    }

    @Test
    public void testGroenCombinaties() {
        List<int[]> possibleArrays = new ArrayList<>();
        CombinationUtil.findAllCombinations(0, Kerstpuzzel17.GROEN, 5, Kerstpuzzel17.GROEN.clone(), possibleArrays);
		for(int[] array : possibleArrays) {
			ArrayUtil.printArray(array);
		}
		assertArrayEquals(new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0}, possibleArrays.get(0));

		possibleArrays = new ArrayList<>();
		CombinationUtil.findAllCombinations(0, Kerstpuzzel17.GROEN, 13, new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26}, possibleArrays);
		Assert.assertEquals(3, possibleArrays.size());
	}

	@Test
	public void testLetterValues() {
		List<int[]> possibleArrays = new ArrayList<>();
		CombinationUtil.findAllCombinations(0, Kerstpuzzel17.GROEN, 13, new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26}, possibleArrays);
		for(int[] array : possibleArrays) {
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[i]; j++) {
					System.out.print(ALPHABET.getLetter(Kerstpuzzel17.GROEN[i]));
				}
			}
			System.out.println();
		}
	}

}
