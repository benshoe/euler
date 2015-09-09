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

    public Problem060(String answer) {
        super(answer);
    }

    @Override
    public void run() {
        long[] primes = new long[]{3, 7, 109, 673};
        boolean found = false;
        while(!found) {
            long[] concatPrimes = PermutationUtil.getPermutationsOfLength2(primes);
            found = testPrimeConcats(concatPrimes);
            if(found && primes.length == 5) {
                found = true;
            }
            else {
                found = false;
                primes = getNewPrimeCombi(primes);
            }
        }
        for (int i = 0; i < primes.length; i++) {
            System.out.println("primes = " + primes[i]);
        }
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
