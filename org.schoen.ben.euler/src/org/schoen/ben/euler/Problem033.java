package org.schoen.ben.euler;


/**
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it
 * may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less than one in value,
 * and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 3, 2014
 */
public class Problem033 extends AbstractEulerProblem {

	public Problem033(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		int answer = 0;
		int tellers = 1;
		int noemers = 1;
		for(double t = 12; t <= 98; t++) {
			double schrapTellerCijfer = t % 10;
			double tellerTientallen = (t - t % 10) / 10;
			if(tellerTientallen == 0) {
				continue;
			}
			for(double n = t + 1; n <= 99; n++) {
				if(n % 10 == 0) {
					continue;
				}
				double schrapNoemerCijfer = (n - n % 10) / 10;
				if(schrapTellerCijfer != schrapNoemerCijfer)
					continue;
				double noemerEnkelen = n % 10;
				if(Double.valueOf(t / n).equals(Double.valueOf(tellerTientallen / noemerEnkelen))) {
					System.out.println(t + "/" + n + " => " + tellerTientallen + "/" + noemerEnkelen);
					tellers *= t;
					noemers *= n;
				}
			}
		}
		System.out.println(tellers);
		System.out.println(noemers);
		setAnswer(String.valueOf(noemers / tellers));
	}

	@Override
	public String getProblemName() {
		return "Problem 33: Find the four non-trivial examples of this type of fraction.";
	}

}
