package org.schoen.ben.euler;

import java.util.*;

public class EulerRunner {

	private static final List<IEulerProblem> m_problems = new ArrayList<>();

	static {
		m_problems.add(new Problem002("4613732"));
		m_problems.add(new Problem003("6857"));
		m_problems.add(new Problem004("913 993"));
		m_problems.add(new Problem005("25164150"));
		m_problems.add(new Problem007("104743"));
		m_problems.add(new Problem008("23514624000"));
		m_problems.add(new Problem009("31875000"));
		m_problems.add(new Problem010("142913828922"));
		m_problems.add(new Problem011("70600674"));
		m_problems.add(new Problem012("76576500"));
		m_problems.add(new Problem013("5537376230390876637302048746832985971773659831892672"));
		m_problems.add(new Problem014("837799"));
		m_problems.add(new Problem015("137846528820"));
		m_problems.add(new Problem016("1366"));
		m_problems.add(new Problem017("21124"));
		m_problems.add(new Problem018("1074"));
		m_problems.add(new Problem019("171"));
		m_problems.add(new Problem020("648"));
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
				System.out.println("Deze oplossing is: " + problem.getAnswer());
			} else {
				System.out.println("The solution is: " + problem.getAnswer());
			}

			long problemTime = System.currentTimeMillis() - problemStartTime;
			System.out.println("This challenge took " + problemTime + " milliseconds to solve.");
		}
		long totalTime = System.currentTimeMillis() - totalStartTime;
		System.out.println();
		System.out.println(numberOfProblems + " out of the " + m_problems.size() + " problems were solved.");
		System.out.println("Solving all " + m_problems.size() + " challenges took " + totalTime + " milliseconds to solve.");
	}

}
