package org.schoen.ben.euler;

public abstract class AbstractEulerProblem implements IEulerProblem {

	private String m_answer = "Niet correct!";

	private String m_correctAnswer;

	public AbstractEulerProblem(String answer) {
		m_correctAnswer = answer;
	}

	@Override
	public abstract void run();

	@Override
	public abstract String getProblemName();

	@Override
	public boolean isCorrectAnswer() {
		return m_correctAnswer.equals(m_answer);
	}

	public void setAnswer(String answer) {
		m_answer = answer;
	}

	@Override
	public String getAnswer() {
		return m_answer;
	}

}
