package org.schoen.ben.euler;

/**
 * Interface for all Euler problems
 *
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 5, 2014
 */
public interface IEulerProblem {

	void run();

	String getProblemName();

	boolean isCorrectAnswer();

	String getAnswer();
}
