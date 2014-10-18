package org.schoen.ben.euler;

import java.io.*;
import java.util.*;

import org.apache.commons.io.*;

public class Problem018 extends AbstractEulerProblem {

	private String m_triangle;

	public Problem018(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		try {
			m_triangle = FileUtils.readFileToString(new File("src/org/schoen/ben/euler/File018.txt"), "UTF8");
		} catch(IOException e) {
			e.printStackTrace();
		}
		String[] triangle = m_triangle.split(" ");
		List<String> list = Arrays.asList(triangle);

		int[][] lines = new int[15][];
		int k = 0;
		for(int i = 0; i < 15; i++) {
			lines[i] = new int[i + 1];
			for(int j = 0; j <= i; j++) {
				lines[i][j] = Integer.valueOf(list.get(k)).intValue();
				k++;
			}
		}

		findMaxSum(lines);
		setAnswer(String.valueOf(lines[0][0]));
	}

	private void findMaxSum(int[][] lines) {
		int currentLine = lines.length - 1;
		while(currentLine > 0) {
			int lineToBeCalculated = currentLine - 1;
			int numberOfValuesInCurrentLine = lines[currentLine].length - 1;
			for(int i = 0; i < numberOfValuesInCurrentLine; i++) {
				int left = lines[lineToBeCalculated][i] + lines[currentLine][i];
				int right = lines[lineToBeCalculated][i] + lines[currentLine][i + 1];
				lines[lineToBeCalculated][i] = Math.max(left, right);
			}
			currentLine--;
		}
	}

	@Override
	public String getProblemName() {
		return "Problem 18: Find the maximum total from top to bottom of the triangle below";
	}

}
