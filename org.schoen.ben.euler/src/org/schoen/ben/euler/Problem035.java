package org.schoen.ben.euler;

import java.util.*;
import java.util.stream.*;

import org.schoen.ben.euler.util.*;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 5, 2014
 */
public class Problem035 extends AbstractEulerProblem {


	public Problem035(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		Set<Integer> circularPrimes = new HashSet<>();
		circularPrimes.add(Integer.valueOf("2"));
		circularPrimes.add(Integer.valueOf("5"));
		for(int i = 3; i < 10000; i += 2) {
			String s = String.valueOf(i);
			if(s.contains("0") || s.contains("2") || s.contains("4") || s.contains("6") || s.contains("8") || s.contains("5"))
				continue;
			boolean allPermutationsArePrime = true;
			if(PrimeUtil.checkPrime(i)) {
				int[] perms = PermutationUtil.getPermutations(i);
				Set<Integer> subSet = new HashSet<>();
				for(int j = 0; j < perms.length; j++) {
					if(PrimeUtil.checkPrime(perms[j])) {
						subSet.add(Integer.valueOf(perms[j]));
					} else {
						//						allPermutationsArePrime = false;
						//						break;
					}
				}
				if(allPermutationsArePrime) {
					circularPrimes.addAll(subSet);
				}
			}
		}
		List<Integer> permms = circularPrimes.stream().sorted().collect(Collectors.toList());
		System.out.println(permms);
		System.out.println(circularPrimes);
		setAnswer(String.valueOf(circularPrimes.size()));
	}

	@Override
	public String getProblemName() {
		return "Problem 35: How many circular primes are there below one million?";
	}

}
