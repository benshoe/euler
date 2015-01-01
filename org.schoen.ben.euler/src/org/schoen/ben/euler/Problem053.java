package org.schoen.ben.euler;

import org.schoen.ben.euler.util.MathUtil;

import java.math.BigInteger;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/1/15.
 */
public class Problem053 extends AbstractEulerProblem {

    public Problem053(String answer) {
        super(answer);
    }

    @Override
    public void run() {
        int numberOfCombinationsGreaterThanOneMillion = 0;
        BigInteger n = new BigInteger("23");
        while (n.intValue() <= 100) {
            BigInteger r = BigInteger.ONE;
            while (r.intValue() <= n.intValue() / 2) {
                BigInteger facN = MathUtil.faculty(n);
                BigInteger facR = MathUtil.faculty(r);
                BigInteger facN_R = MathUtil.faculty(n.subtract(r));
                if (facN.divide(facR.multiply(facN_R)).intValue() > 1000000) {
                    numberOfCombinationsGreaterThanOneMillion += n.subtract(r).subtract(r).add(BigInteger.ONE).intValue();
                    break;
                }
                r = r.add(BigInteger.ONE);
            }
            n = n.add(BigInteger.ONE);
        }
        setAnswer(String.valueOf(numberOfCombinationsGreaterThanOneMillion));
    }

    @Override
    public String getProblemName() {
        return "Problem 53: How many, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, are greater than one-million?";
    }
}
