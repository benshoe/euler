package org.schoen.ben.euler;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import org.schoen.ben.euler.util.*;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten triangle numbers are:
 *
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values
 * we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
 * If the word value is a triangle number then we shall call the word a triangle word.
 *
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly two-thousand common English words,
 * how many are triangle words?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 7, 2014
 */
public class Problem042 extends AbstractEulerProblem {

	private static final String REGEXP = "\\W+"; // for splitting into words

	public Problem042(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		BufferedReader reader = FileUtil.readFile("File042.txt");
		if(reader == null) {
			System.out.println("Er ging iets fout met het lezen van de file...");
		}
		List<Integer> triangleNumbers = getTriangleNumbers(1000);
		System.out.println(triangleNumbers);
		List<String> words = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).collect(Collectors.toList());
		int answer = 0;
		for(String word : words) {
			Integer wordValue = getWordValue(word.toUpperCase());
			if(triangleNumbers.contains(wordValue))
				answer++;
		}
		setAnswer(String.valueOf(answer));
	}

	private List<Integer> getTriangleNumbers(int until) {
		List<Integer> values = new ArrayList<Integer>();
		for(double n = 1; n <= until; n++) {
			double value = 0.5 * n * (n + 1);
			values.add(new Integer((int) value));
		}
		return values;
	}

	private Integer getWordValue(String word) {
		char[] letters = word.toCharArray();
		int value = 0;
		for(int i=0;i<letters.length; i++) {
			value += letters[i] - 64;
		}
		return new Integer(value);
	}

	@Override
	public String getProblemName() {
		return "Problem 42: How many of the provided words are triangle words?";
	}

}
