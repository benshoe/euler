package org.schoen.ben.euler.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 *         Created on 12/24/14.
 */
public class PrimeFamilyCalculator {
    private static PrimeFamilyCalculator m_instance = new PrimeFamilyCalculator();
    private static BigInteger m_prime;

    private List<PrimeFamily> m_primeFamilies = new ArrayList<>();

    public static PrimeFamilyCalculator getInstance() {
        return m_instance;
    }

    private PrimeFamilyCalculator() {
    }

    public static List<PrimeFamily> getPrimeFamilies(BigInteger prime) {
        m_prime= prime;
        Map<Integer, List<Integer>> duplicateNumbers = findDuplicateNumbers(prime.toString());
        return createFamilies(duplicateNumbers);
    }

    private static List<PrimeFamily> createFamilies(Map<Integer, List<Integer>> duplicateNumbers) {
        for(Map.Entry entry: duplicateNumbers.entrySet()){
            List<Integer> positions = (List<Integer>) entry.getValue();
            if (positions.size() > 1) {
                PrimeFamily pf = new PrimeFamily(m_prime.toString().length(), ((Integer) entry.getKey()).intValue(), 534, (Integer[]) positions.toArray());
            }
        }
        return null;
    }

    private static Map<Integer, List<Integer>> findDuplicateNumbers(String s) {
        Map<Integer, List<Integer>> numbers = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            Integer number = Integer.valueOf(s.charAt(i));
            List<Integer> positions = numbers.get(number);
            if(positions == null) {
                positions = new ArrayList<>();
                positions.add(i);
                numbers.put(number, positions);
            }
            positions.add(i);
        }
        return numbers;
    }
}
