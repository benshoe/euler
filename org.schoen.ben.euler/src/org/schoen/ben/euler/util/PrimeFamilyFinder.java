package org.schoen.ben.euler.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/1/15.
 */
public class PrimeFamilyFinder {

    private static List<String> m_primes;

    public static int getNumberOfPrimeFamilyMembers(String prime, int... pos) {
        m_primes = new ArrayList<>();
        StringBuilder sb = new StringBuilder(prime);
        int numberOfPrimeFamilyMembers = 0;
        for (int i = 0; i < 10; i++) {
            for (int p : pos) {
                sb = sb.replace(p, p + 1, String.valueOf(i));
            }
            if(PrimeUtil.isPrime(Long.valueOf(sb.toString()).longValue())) {
                if(sb.charAt(0)!='0') {
                    numberOfPrimeFamilyMembers++;
                    addPrime(sb.toString());
                }
            }
        }
        return numberOfPrimeFamilyMembers;
    }

    public static int getNumberOfPrimeFamilyMembers(String prime, int valueToReplace) {
        m_primes = new ArrayList<>();
        StringBuilder sb;
        String s = prime;
        int numberOfPrimeFamilyMembers = 0;
        for (int i = 0; i < 10; i++) {
            sb = new StringBuilder(prime);
            s = prime.replaceAll(String.valueOf(valueToReplace), String.valueOf(i));
            if(PrimeUtil.isPrime(Long.valueOf(s).longValue())) {
                if(s.charAt(0)!='0') {
                    numberOfPrimeFamilyMembers++;
                    addPrime(s);
                }
            }
        }
        return numberOfPrimeFamilyMembers;
    }

    private static void addPrime(String s) {
        m_primes.add(s);
    }

    public static List<String> getPrimes() {
        return m_primes;
    }
}
