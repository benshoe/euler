package org.schoen.ben.euler;


public class TryoutArray implements IEulerProblem {

	@Override
	public void run() {
		long[] primes = PrimeUtil.getPrimes(2000000);
		long sum = 0;
		for(long l : primes) {
			//			System.out.println(l);
			sum += l;
		}
		System.out.println("Total is: " + sum);
	}

	@Override
	public String getProblemName() {
		return "Trying out array";
	}

}
