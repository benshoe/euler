package org.schoen.ben.euler.util;

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
    private static Map<PrimeFamily, List<Prime>> m_primeFamilies = new HashMap<>();

    public static PrimeFamilyCalculator getInstance() {
        return m_instance;
    }

    private PrimeFamilyCalculator() {
    }

    public static Map<PrimeFamily, List<Prime>> getPrimeFamilies() {
        return m_primeFamilies;
    }

    private static int getNumberLeft(String prime, int... pos) {
        StringBuilder numberLeft = new StringBuilder(prime);
        int counter = 0;
        for (int p : pos) {
            numberLeft.deleteCharAt(p-counter);
            counter++;
        }
        return Integer.valueOf(numberLeft.toString()).intValue();
    }

    public static void addPrime(long prime) {
        String p = Long.valueOf(prime).toString();
        int primeLength = p.length();
        /*for (int i = 0; i <= primeLength - 1; i++) {
            String numberLeft = getNumberLeft(p, i);
            PrimeFamily pf = new PrimeFamily(primeLength, p.charAt(i) - 48, new Integer(numberLeft).intValue(), new Integer[]{i});
            List<Prime> primes = m_primeFamilies.get(pf);
            if (primes == null) {
                primes = new ArrayList<>();
                m_primeFamilies.put(pf, primes);
            }
            primes.add(new Prime(prime));
        }*/
        // Nu de duplicates vinden
        for (int i = 0; i <= primeLength - 2; i++) {
            for (int j = i + 1; j <= primeLength - 2; j++) {
                if(p.charAt(i) == p.charAt(j)) {
                    int numberLeft = getNumberLeft(p, i, j);
                    PrimeFamily pf = new PrimeFamily(primeLength, p.charAt(i) - 48, numberLeft, new Integer[]{i, j});
                    List<Prime> primes = m_primeFamilies.get(pf);
                    if (primes == null) {
                        primes = new ArrayList<>();
                        m_primeFamilies.put(pf, primes);
                    }
                    primes.add(new Prime(prime));
                }
            }
        }
    }

    public void clear() {
        m_primeFamilies = new HashMap<>();
    }
}
