package org.schoen.ben.euler;

/**
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9^ + 16^ = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 5, 2014
 */
public class Problem009 implements IEulerProblem {

	private String m_answer;

	@Override
	public void run() {
		for(int x = 1; x < 998; x++) {
			for(int y = x + 1; y < 999; y++) {
				int z = 1000 - x - y;
				if(Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2)) {
					System.out.println("Found! (x, y, z): (" + x + ", " + y + ", " + z + ")");
					System.out.println(x + "^2 = " + Math.pow(x, 2));
					System.out.println(y + "^2 = " + Math.pow(y, 2));
					System.out.println(z + "^2 = " + Math.pow(z, 2));
					System.out.println(x + " + " + y + " + " + z + " = " + (x + y + z));
					m_answer = String.valueOf(x * y * z);
					System.out.println("The product of xyz = " + m_answer);
				}
			}
		}
	}

	@Override
	public String getProblemName() {
		return "Problem 9: Find the Pythagorean triplet for which a + b + c = 1000.";
	}

	@Override
	public boolean isCorrectAnswer() {
		return "31875000".equals(m_answer);
	}
}
