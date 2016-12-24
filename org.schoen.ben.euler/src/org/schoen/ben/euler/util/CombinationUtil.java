package org.schoen.ben.euler.util;

import java.util.*;

/**
 * Created by ben on 24-12-16.
 */
public class CombinationUtil {

    public static int findCombinationsCount(int amount, int coins[]) {
        return findCombinationsCount(amount, coins, 0);
    }

    private static int findCombinationsCount(int amount, int coins[], int checkFromIndex) {
        if(amount == 0)
            return 1;
        else if(amount < 0 || coins.length == checkFromIndex)
            return 0;
        else {
            int withFirstCoin = findCombinationsCount(amount - coins[checkFromIndex], coins, checkFromIndex);
            int withoutFirstCoin = findCombinationsCount(amount, coins, checkFromIndex + 1);
            return withFirstCoin + withoutFirstCoin;
        }
    }

    public static List<List<Integer>> findCombinations(int sum, int[] numbers) {
        List<List<Integer>> combinations = new ArrayList<>();
        combinations.add(findCombinations(combinations, new ArrayList<>(), sum, numbers, 0));
        return combinations;
    }

    private static List<Integer> findCombinations(List<List<Integer>> combinations, List<Integer> combination, int sum, int[] numbers, int checkFromIndex) {
        if(sum == 0) {
            combinations.add(combination);
            return combination;
        }
        if(sum < 0 || numbers.length == checkFromIndex) {
            return Collections.EMPTY_LIST;
        }
        combination.add(numbers[checkFromIndex]);
        List<Integer> withFirstNumber = findCombinations(combinations, combination, sum - numbers[checkFromIndex], numbers, checkFromIndex);
        combination = new ArrayList<>();
        List<Integer> withoutFirstNumber = findCombinations(combinations, combination, sum, numbers, checkFromIndex + 1);
        combination.addAll(withFirstNumber);
        combination.addAll(withoutFirstNumber);
        List<Integer> complete = new ArrayList<>(withFirstNumber);
        complete.addAll(withoutFirstNumber);
        return complete;
    }
}
