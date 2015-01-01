package org.schoen.ben.euler;

import java.util.*;

public class EulerRunner {

	private static final List<IEulerProblem> m_problems = new ArrayList<>();

	static {
		//		m_problems.add(new Problem001("233168"));
		//		m_problems.add(new Problem002("4613732"));
		//		m_problems.add(new Problem003("6857"));
		//		m_problems.add(new Problem004("913 993"));
		//		m_problems.add(new Problem005("25164150"));
		//		m_problems.add(new Problem006("25164150"));
		//		m_problems.add(new Problem007("104743"));
		//		m_problems.add(new Problem008("23514624000"));
		//		m_problems.add(new Problem009("31875000"));
		//		m_problems.add(new Problem010("142913828922"));
		//		m_problems.add(new Problem011("70600674"));
		//		m_problems.add(new Problem012("76576500"));
		//		m_problems.add(new Problem013("5537376230390876637302048746832985971773659831892672"));
		//		m_problems.add(new Problem014("837799"));
		//		m_problems.add(new Problem015("137846528820"));
		//		m_problems.add(new Problem016("1366"));
		//		m_problems.add(new Problem017("21124"));
		//		m_problems.add(new Problem018("1074"));
		//		m_problems.add(new Problem019("171"));
		//		m_problems.add(new Problem020("648"));
		//		m_problems.add(new Problem021("31626"));
		//		m_problems.add(new Problem022("871198282"));
		//		m_problems.add(new Problem023("4179871"));
		//		m_problems.add(new Problem024("2783915460"));
		//		m_problems.add(new Problem025("4782"));
		//		m_problems.add(new Problem026("983"));
		//		m_problems.add(new Problem027("-59231"));
		//		m_problems.add(new Problem028("669171001"));
		//		m_problems.add(new Problem029("9183"));
		//		m_problems.add(new Problem030("443839"));
		//		m_problems.add(new Problem031("73682"));
		//		m_problems.add(new Problem032("45228"));
		//		m_problems.add(new Problem033("100"));
		//		m_problems.add(new Problem034("40730"));
		//		m_problems.add(new Problem035("55"));
		//		m_problems.add(new Problem036("872187"));
//				m_problems.add(new Problem037("748317"));
		//		m_problems.add(new Problem038("932718654"));
		//		m_problems.add(new Problem039("840")); // doet er lang over (23 seconden)
		//		m_problems.add(new Problem040("210"));
		//		m_problems.add(new Problem041("7652413"));
		//		m_problems.add(new Problem042("162"));
		//		m_problems.add(new Problem043("16695334890"));
		//		m_problems.add(new Problem044("5482660")); //doet er lang over (57 seconden)
		//		m_problems.add(new Problem045("1533776805"));
		//		m_problems.add(new Problem046("5777"));
		//		m_problems.add(new Problem047("134043"));
		//		m_problems.add(new Problem048("9110846700"));
		//		m_problems.add(new Problem049("296962999629"));
		//		m_problems.add(new Problem050("997651"));
		m_problems.add(new Problem051(""));
		m_problems.add(new Problem052("142857"));
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
				numberOfProblems--;
				System.out.println("FOUT FOUT FOUT: " + problem.getAnswer());
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
