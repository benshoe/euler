package org.schoen.ben.euler;

import org.schoen.ben.euler.util.PermutationUtil;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 *         Created on 12/31/14.
 */
public class Problem052 extends AbstractEulerProblem {

    public Problem052(String answer) {
        super(answer);
    }

    @Override
    public void run() {
        boolean found = false;
        long x = 1L;
        while(!found) {
            long x2 = 2*x;
            long x3 = 3*x;
            if(compare(x2, x3)) {
                long x4 = 4 * x;
                if(compare(x3, x4)) {
                    long x5 = 5*x;
                    if(compare(x4, x5)) {
                        long x6 = 6*x;
                        if(compare(x5, x6)) {
                            found = true;
                        }
                    }
                }
            }
            x++;
        }
        setAnswer(String.valueOf(--x));
    }

    private boolean compare(long x1, long x2) {
        long[] permutations = PermutationUtil.getPermutations(x1);
        for(long perm: permutations) {
            if(perm == x2)
                return true;
        }
        return false;
    }

    @Override
    public String getProblemName() {
        return "Problem 52: Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.";
    }
}
