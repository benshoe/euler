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

    public static Set<List<Integer>> findCombinations(int sum, int[] numbers) {
        Set<List<Integer>> combinations = new HashSet<>();
        combinations.add(findCombinations(combinations, new ArrayList<>(), sum, numbers, 0));
        return combinations;
    }

    private static List<Integer> findCombinations(Set<List<Integer>> combinations, List<Integer> combination, int amount, int[] numbers, int checkFromIndex) {
        if(amount == 0) {
            return combination;
        }
        if(amount < 0 || numbers.length == checkFromIndex) {
            return Collections.EMPTY_LIST;
        }
        combination.add(numbers[checkFromIndex]);
        List<Integer> withFirstNumber = findCombinations(combinations, combination, amount - numbers[checkFromIndex], numbers, checkFromIndex);
        combinations.add(withFirstNumber);

        combination = new ArrayList<>();
        List<Integer> withoutFirstNumber = findCombinations(combinations, combination, amount, numbers, checkFromIndex + 1);
        if(withoutFirstNumber.size() != 0) {
            combinations.add(withoutFirstNumber);
        }
        return combination;
    }

    public static void printAll(int ind, int[] denom, int N, int[] vals){
        if(N==0){
            System.out.println(Arrays.toString(vals));
            return;
        }
        if(ind == (denom.length))return;
        int currdenom = denom[ind];
        for(int i=0;i<=(N/currdenom);i++){
            vals[ind] = i;
            printAll(ind+1,denom,N-i*currdenom,vals);
        }
    }
}
