package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

import java.math.*;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 1/12/15.
 */
public class Problem055 extends AbstractEulerProblem {

    private static final long MAX_VALUE = 10000l;

    public Problem055(String answer) {
        super(answer);
    }

    @Override
    public void run() {
        int answer = 9999;
        BigInteger value = BigInteger.ONE;
        while(value.longValue() < MAX_VALUE) {
            int counter = 0;
            boolean found = false;
            BigInteger startValue = value;
            while(!found && counter < 50) {
                BigInteger newSum = startValue.add(getReverse(startValue));
                if(MathUtil.isPalindrome(newSum.toString())) {
                    found = true;
                    answer--;
                }
                counter++;
                startValue = newSum;
            }
            value = value.add(BigInteger.ONE);
        }
        setAnswer(String.valueOf(answer));
    }

    private BigInteger getReverse(BigInteger i) {
        StringBuilder sb = new StringBuilder(i.toString());
        return new BigInteger(sb.reverse().toString());
    }

    @Override
    public String getProblemName() {
        return "Problem 55: How many Lychrel numbers are there below ten-thousand?";
    }
}
