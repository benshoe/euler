package org.schoen.ben.euler;

import java.math.*;
import java.util.*;

public class TryoutBigInteger implements IEulerProblem {

	@Override
	public void run() {
		List<BigInteger> primes = PrimeUtil.getPrimesUpUntil(200000);
		long sum = 0;
		for(BigInteger l : primes) {
			System.out.println(l);
			sum += l.longValue();
		}
		System.out.println("Total is: " + sum);
	}

	@Override
	public String getProblemName() {
		return "Trying out List<BigInteger>";
	}

}
