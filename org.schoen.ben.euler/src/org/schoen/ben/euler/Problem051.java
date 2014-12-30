package org.schoen.ben.euler;

import org.schoen.ben.euler.util.Prime;
import org.schoen.ben.euler.util.PrimeFamily;
import org.schoen.ben.euler.util.PrimeFamilyCalculator;
import org.schoen.ben.euler.util.PrimeUtil;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
 * 13, 23, 43, 53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit,
 * this 5-digit number is the first example having seven primes among the ten generated numbers,
 * yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993.
 *
 * Consequently 56003, being the first member of this family, is the smallest prime with this property.
 *
 * Find the smallest prime which,
 * by replacing part of the number (not necessarily adjacent digits) with the same digit,
 * is part of an eight prime value family.
 *
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
		PrimeFamily primeFamily = null;
		int i = 11;
		int counter = 1;
		int familySize = 0;
		while(familySize < 8) {
			if (counter % 50000 == 0) {
				primeFamily = findMaxPrimeFamily(PrimeFamilyCalculator.getPrimeFamilies());
				familySize = PrimeFamilyCalculator.getPrimeFamilies().get(primeFamily).size();
				System.out.println(counter);
				System.out.println(PrimeFamilyCalculator.getPrimeFamilies().get(primeFamily));
			}
			if (PrimeUtil.isPrime(i)) {
				PrimeFamilyCalculator.addPrime(new BigInteger(Integer.valueOf(i).toString()));
			}
			i += 2;
			counter += 1;
		}
		System.out.println(PrimeFamilyCalculator.getPrimeFamilies().get(primeFamily));
	}

	private PrimeFamily findMaxPrimeFamily(Map<PrimeFamily, List<Prime>> primeFamilies) {
		int maxPrimeFamilySize = 0;
		PrimeFamily primeFamily = null;
		for(PrimeFamily pf: primeFamilies.keySet()) {
			List<Prime> primes = primeFamilies.get(pf);
			if(primes.size() > maxPrimeFamilySize) {
				maxPrimeFamilySize = primes.size();
				primeFamily = pf;
			}
		}
		return primeFamily;
	}

	@Override
	public String getProblemName() {
		return "Problem 51: Find the smallest prime which is part of an eight prime value family.";
	}

}
