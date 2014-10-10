package org.schoen.ben.euler;

import java.util.*;

public class EulerRunner {

	private static final List<IEulerProblem> m_problems = new ArrayList<>();

	static {
		/*m_problems.add(new Opdracht2());
		m_problems.add(new Opdracht3());
		m_problems.add(new Opdracht4());
		m_problems.add(new Opdracht5());
		m_problems.add(new Opdracht7());
		m_problems.add(new Opdracht8());
		m_problems.add(new Opdracht9());
		m_problems.add(new Opdracht10());*/
		//		m_problems.add(new TryoutBigInteger());
		//		m_problems.add(new TryoutArray());
		m_problems.add(new Opdracht11());
	}

	public static void main(String[] args) {
		for(IEulerProblem problem : m_problems) {
			System.out.println("#########################################");
			System.out.println(problem.getProblemName());
			long startTime = System.currentTimeMillis();

			problem.run();

			long endTime = System.currentTimeMillis();
			long totalTime = endTime - startTime;
			System.out.println("This challenge took " + totalTime + " milliseconds to solve.");
		}
	}

}
