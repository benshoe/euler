package org.schoen.ben.euler;

import org.schoen.ben.euler.util.PrimeFamilyFinder;
import org.schoen.ben.euler.util.PrimeUtil;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
 * 13, 23, 43, 53, 73, and 83, are all prime.
 * <p>
 * By replacing the 3rd and 4th digits of 56**3 with the same digit,
 * this 5-digit number is the first example having seven primes among the ten generated numbers,
 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 * <p>
 * Consequently 56003, being the first member of this family, is the smallest prime with this property.
 * <p>
 * Find the smallest prime which,
 * by replacing part of the number (not necessarily adjacent digits) with the same digit,
 * is part of an eight prime value family.
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 12, 2014
 */
public class Problem051 extends AbstractEulerProblem {

    public Problem051(String answer) {
        super(answer);
    }

    @Override
    public void run() {
        boolean found = false;
        long possiblePrime = 1;
        while (!found) {
            possiblePrime += 2;
            if(PrimeUtil.isPrime(possiblePrime)) {
                String p = Long.valueOf(possiblePrime).toString();
                int primeLength = p.length();
                for (int i = 0; i <= primeLength - 2; i++) {
                    for (int j = i + 1; j <= primeLength - 2; j++) {
                        if (p.charAt(i) == p.charAt(j)) {
                            int familyMembers = PrimeFamilyFinder.getNumberOfPrimeFamilyMembers(p, p.charAt(i) - 48);
                            if (familyMembers == 8) {
                                found = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        setAnswer(String.valueOf(possiblePrime));
        System.out.println(PrimeFamilyFinder.getPrimes());
    }

    @Override
    public String getProblemName() {
        return "Problem 51: Find the smallest prime which is part of an eight prime value family.";
    }

}
