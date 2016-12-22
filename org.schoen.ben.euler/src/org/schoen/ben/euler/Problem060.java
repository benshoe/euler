package org.schoen.ben.euler;

import org.schoen.ben.euler.util.PermutationUtil;
import org.schoen.ben.euler.util.PrimeUtil;

/**
 *
 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order
 * the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime.
 * The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 9/7/15.
 */
public class Problem060 extends AbstractEulerProblem {

    private final int numberToTry = 10000;

    long[] m_primes = new long[numberToTry];

    public Problem060(String answer) {
        super(answer);
    }

    @Override
    public void run() {
        tryout();
        boolean found = false;
        boolean noMoreLeft = false;
        long[] primes = new long[5];
        int numberOfCombinations = 0;
        while(!found && !noMoreLeft) {
            for (int a = 0; a < numberToTry; a++) {
                primes[0] = m_primes[a];
                for (int b = 1; b < numberToTry; b++) {
                    primes[1] = m_primes[b];
                    if(primes[1] <= primes[0]) continue;
                    for (int c = 2; c < numberToTry; c++) {
                        primes[2] = m_primes[c];
                        if(primes[2] <= primes[1]) continue;
                        for (int d = 3; d < numberToTry; d++) {
                            primes[3] = m_primes[d];
                            if(primes[3] <= primes[2]) continue;
                            for (int e = 4; e < numberToTry; e++) {
                                primes[4] = m_primes[e];
                                if(primes[4] <= primes[3]) continue;
                                long[] concatPrimes = PermutationUtil.getPermutationsOfLength2(primes);
                                numberOfCombinations++;
                                if(numberOfCombinations % 1_000_000 == 0) {
                                    System.out.println("numberOfCombinations = " + numberOfCombinations);
                                    printPrimes(primes);
                                }
                                if (testPrimeConcats(concatPrimes)) {
                                    found = true;
                                    System.out.println("GEVONDEN GEVONDEN GEVONDEN");
                                    printPrimes(primes);
                                }
                            }
                        }
                    }
                }
            }
            System.out.println("numberOfCombinations done: " + numberOfCombinations);
            noMoreLeft = true;
        }
        /*long[] primes = new long[]{3, 7, 109, 673};
        boolean found = false;
        int numberProcessed = 0;
        while(!found) {
            numberProcessed++;
            found = testPrimeConcats(concatPrimes);
            if(found && primes.length == 5) {
                found = true;
                printPrimes(primes);
            }
            else {
                found = false;
                primes = getNewPrimeCombi(primes);
                if(numberProcessed % 1000 == 0) {
                    printPrimes(primes);
                }
            }
        }
        printPrimes(primes);*/
    }

    private void tryout() {
        long prime = 7;
        m_primes[0] = 3;
        m_primes[1] = 7;
        m_primes[2] = 73;
        for (int i = 3; i < numberToTry; i++) {
            long nextPrime = getNextPrime(prime);
            m_primes[i] = nextPrime;
            prime = nextPrime;
        }
        printPrimes(m_primes);
    }

    private void printPrimes(long[] primes) {
        System.out.print("primes = ");
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i] + " ");
        }
        System.out.println();
    }

    private boolean testPrimeConcats(long[] primes) {
        for (int i = 0; i < primes.length; i++) {
            if(!PrimeUtil.isPrime(primes[i]))
                return false;
        }
        return true;
    }

    private long[] getNewPrimeCombi(long[] primes) {
        long prime = 2;
        if(primes.length < 5) {
            long[] newPrimes = new long[5];
            newPrimes[0] = primes[0];
            newPrimes[1] = primes[1];
            newPrimes[2] = primes[2];
            newPrimes[3] = primes[3];
            primes = newPrimes;
            prime = primes[primes.length - 2];
        } else {
            prime = primes[primes.length - 1];
        }
        long newPrime = getNextPrime(prime);
        primes[primes.length - 1] = newPrime;
        return primes;
    }

    private long getNextPrime(long prime) {
        long testNumber = prime + 2;
        while(!PrimeUtil.isPrime(testNumber)) {
            testNumber += 2;
        }
        return testNumber;
    }

    @Override
    public String getProblemName() {
        return "Problem 060: Prime pair sets; Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.";
    }
}
