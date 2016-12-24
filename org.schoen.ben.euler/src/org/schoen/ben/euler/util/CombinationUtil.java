package org.schoen.ben.euler.util;

import java.util.List;

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

    public static List<List<Integer>> findCombinations(int i, int[] ints) {
        return null;
    }
}
