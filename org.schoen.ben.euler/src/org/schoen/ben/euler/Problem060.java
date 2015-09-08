package org.schoen.ben.euler;

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
        int[] primes = new int[]{3, 7, 11, 13, 17};
        boolean found = false;
        while(!found) {
            primes = getNewPrimeCombi(primes);
            found = testPrimeConcats(primes);
        }
    }

    private boolean testPrimeConcats(int[] primes) {

        return false;
    }

    private int[] getNewPrimeCombi(int[] primes) {

        return new int[0];
    }

    @Override
    public String getProblemName() {
        return "Problem 060: Prime pair sets; Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.";
    }
}
