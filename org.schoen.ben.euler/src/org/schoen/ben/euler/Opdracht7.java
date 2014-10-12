package org.schoen.ben.euler;


/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 5, 2014
 */
public class Opdracht7 implements IEulerProblem {

	@Override
	public void run() {
		int count = 1;
		int i = 3;
		while(count != 10000) {
			if(PrimeUtil.checkPrime(i += 2))
				count++;
		}
		System.out.println(i);
		//		List<BigInteger> primes = PrimeUtil.getPrimesUpUntil(110000l);
		//		System.out.println();
		//		System.out.println("Number of primes found: " + primes.size());
		//		System.out.println("Prime " + 10001 + ": " + primes.get(10000));
		//		if(primes.get(10000).intValue() != 104743) {
		//			System.out.println("WRONG WRONG WRONG WRONG WRONG ");
		//		}
	}

	@Override
	public String getProblemName() {
		return "Problem 7: What is the 10 001st prime number?";
	}

}
