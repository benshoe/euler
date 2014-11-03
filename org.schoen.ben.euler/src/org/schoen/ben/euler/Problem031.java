package org.schoen.ben.euler;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 *
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 31, 2014
 */
public class Problem031 extends AbstractEulerProblem {

	public Problem031(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int answer = findCombinationsCount(200, new int[]{1, 2, 5, 10, 20, 50, 100, 200});
		setAnswer(String.valueOf(answer));
	}

	private int findCombinationsCount(int amount, int coins[]) {
		return findCombinationsCount(amount, coins, 0);
	}

	private int findCombinationsCount(int amount, int coins[], int checkFromIndex) {
		if(amount == 0)
			return 1;
		else if(amount < 0 || coins.length == checkFromIndex)
			return 0;
		else {
			int withFirstCoin = findCombinationsCount(amount - coins[checkFromIndex], coins, checkFromIndex);
			int withoutFirstCoin = findCombinationsCount(amount, coins, checkFromIndex + 1);
			return withFirstCoin + withoutFirstCoin;
		}
	}

	@Override
	public String getProblemName() {
		return "Problem 31: How many different ways can £2 be made using any number of coins?";
	}

}
