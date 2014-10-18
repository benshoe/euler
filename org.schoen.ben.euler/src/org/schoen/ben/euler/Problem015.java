package org.schoen.ben.euler;

/**
 * Starting in the top left corner of a 2×2 grid,
 * and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since Oct 11, 2014
 */
public class Problem015 implements IEulerProblem {

	private String m_answer;

	@Override
	public void run() {
		calculateGrid(21);
	}

	private void calculateGrid(int size) {
		long[][] grid = new long[size][size];
		for(int i = 0; i < size; i++) {
			grid[0][i] = 1;
			grid[i][0] = 1;
			System.out.print("1  ");
		}
		System.out.println();
		for(int i = 1; i < size; i++) {
			System.out.print("1  ");
			for(int j = 1; j < size; j++) {
				long value = grid[i - 1][j] + grid[i][j - 1];
				grid[i][j] = value;
				System.out.print(value + "  ");
			}
			System.out.println();
		}
		m_answer = String.valueOf(grid[20][20]);
	}

	@Override
	public String getProblemName() {
		return "Problem 15: How many such routes are there through a 20×20 grid?";
	}

	@Override
	public boolean isCorrectAnswer() {
		return "137846528820".equals(m_answer);
	}

}
