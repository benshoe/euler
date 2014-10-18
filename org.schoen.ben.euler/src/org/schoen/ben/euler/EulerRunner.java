package org.schoen.ben.euler;

import java.util.*;

public class EulerRunner {

	private static final List<IEulerProblem> m_problems = new ArrayList<>();

	static {
		//		m_problems.add(new Opdracht2());
		//		m_problems.add(new Opdracht3());
		//		m_problems.add(new Opdracht4());
		//		m_problems.add(new Opdracht5());
		//		m_problems.add(new Opdracht7());
		//		m_problems.add(new Opdracht8());
		//		m_problems.add(new Opdracht9());
		//		m_problems.add(new Opdracht10());
		//		m_problems.add(new Opdracht11());
		//		m_problems.add(new Problem012());
		//		m_problems.add(new Problem013());
		//		m_problems.add(new Problem014());
		//		m_problems.add(new Problem015());
		//		m_problems.add(new Problem016());
		//		m_problems.add(new Problem017());
		m_problems.add(new Problem018());
	}

	public static void main(String[] args) {
		long totalStartTime = System.currentTimeMillis();
		int numberOfProblems = m_problems.size();
		for(IEulerProblem problem : m_problems) {
			System.out.println("#########################################");
			System.out.println(problem.getProblemName());
			long problemStartTime = System.currentTimeMillis();

			problem.run();
			if(!problem.isCorrectAnswer()) {
				System.out.println("THIS PROBLEM IS NOT SOLVED!!!!!");
				numberOfProblems--;
			}

			long problemTime = System.currentTimeMillis() - problemStartTime;
			System.out.println("This challenge took " + problemTime + " milliseconds to solve.");
		}
		long totalTime = System.currentTimeMillis() - totalStartTime;
		System.out.println();
		System.out.println();
		System.out.println(numberOfProblems + " out of the " + m_problems.size() + " problems were solved.");
		System.out.println("Solving all " + m_problems.size() + " challenges took " + totalTime + " milliseconds to solve.");
	}

}
