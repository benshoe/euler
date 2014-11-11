package org.schoen.ben.euler;

import java.util.*;

import org.schoen.ben.euler.util.*;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property,
 * but there is one other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 11, 2014
 */
public class Problem049 extends AbstractEulerProblem {

	public Problem049(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		Map<String, List<Integer>> possiblePrimes = new HashMap<>();
		for(int i = 1001; i < 9999; i++) {
			String[] perms = PermutationUtil.getPermutations(String.valueOf(i));
			List<Integer> primes = new ArrayList<>();
			for(int j = 0; j < perms.length; j++) {
				String p = perms[j];
				if(p == null)
					continue;
				Integer prime = new Integer(perms[j]);
				if(prime.intValue() > 1000 && PrimeUtil.isPrime(prime.intValue())) {
					primes.add(prime);
				}
			}
			if(primes.size() >= 3) {
				possiblePrimes.put(String.valueOf(i), primes);
			}
		}

		System.out.println(possiblePrimes);

		String answer = "";
		boolean found = false;
		for(Map.Entry<String, List<Integer>> primes : possiblePrimes.entrySet()) {
			Map<Integer, Set<Integer>> differences = calculateDifferences(primes.getValue());
			for(Map.Entry<Integer, Set<Integer>> diff : differences.entrySet()) {
				if(diff.getValue().size() == 3 && !diff.getValue().contains(Integer.valueOf(4817))) {
					for(Integer number : diff.getValue()) {
						System.out.println("Het gevonden verschil: " + diff.getKey());
						answer += number.toString();
						found = true;
					}
				}
			}
			if(found) {
				setAnswer(answer);
				break;
			}
		}
	}

	/*
	 * Voor elk gevonden priemgetal van bijv. de combinatie 2792=[2297, 2729, 2927, 7229, 9227]
	 * wordt het verschil met elk ander getal berekend in de lijst (zolang het verschil positief is).
	 * Die verschillen worden in een Map gestopt als key en de value is een Set van de bijbehorende
	 * priemgetallen. Die Map wordt teruggegeven aan de vorige methode.
	 */
	private Map<Integer, Set<Integer>> calculateDifferences(List<Integer> value) {
		Map<Integer, Set<Integer>> diffs = new HashMap<>();
		Integer[] primes = new Integer[value.size()];
		for(int i = 0; i < value.size(); i++) {
			primes[i] = value.get(i);
		}
		for(int i = primes.length - 1; i >= 1; i--) {
			for(int j = i - 1; j >= 0; j--) {
				Integer diff = Integer.valueOf(primes[i].intValue() - primes[j].intValue());
				if(diffs.containsKey(diff)) {
					Set<Integer> list = diffs.get(diff);
					list.add(primes[i]);
					list.add(primes[j]);
				} else {
					Set<Integer> list = new HashSet<>();
					list.add(primes[i]);
					list.add(primes[j]);
					diffs.put(diff, list);
				}
			}
		}
		return diffs;
	}

	@Override
	public String getProblemName() {
		return "Problem 49: What 12-digit number do you form by concatenating the three terms in this sequence?";
	}

}
