package org.schoen.ben.euler;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import org.schoen.ben.euler.util.*;

/**
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Oct 20, 2014
 */
public class Problem022 extends AbstractEulerProblem {

	static final String REGEXP = "\\W+"; // for splitting into words

	public Problem022(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		BufferedReader reader = FileUtil.readFile("File022.txt");
		if(reader == null) {
			System.out.println("Er ging iets fout met het lezen van de file...");
		}
		List<String> names = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).sorted().collect(Collectors.toList());
		int sum = 0;
		for(String name : names) {
			sum += calculate(name) * (names.indexOf(name));
		}
		setAnswer(String.valueOf(sum));
	}

	private int calculate(String name) {
		int sum = 0;
		for(int i = name.length() - 1; i >= 0; i--) {
			sum += name.charAt(i) - 64;
		}
		return sum;
	}

	@Override
	public String getProblemName() {
		return "Problem 22: What is the total of all the name scores in the file?";
	}

}
