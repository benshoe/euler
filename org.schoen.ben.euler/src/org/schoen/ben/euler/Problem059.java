package org.schoen.ben.euler;

import org.schoen.ben.euler.util.*;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 2/4/15.
 */
public class Problem059 extends AbstractEulerProblem {

	private static final int SMALLEST_LETTER = 97;

	private static final int LARGEST_LETTER = 123;

	public Problem059(String answer) {
		super(answer);
	}

	@Override public void run() {
		BufferedReader bufferedReader = FileUtil.readFile("File059.txt");
		List<String> values = bufferedReader.lines().flatMap(s -> Stream.of(s.split(","))).collect(Collectors.toList());
		System.out.println("values = " + values.size());
		System.out.println("values = " + values);
		byte[] intValues = new byte[values.size()];
		int i = 0;
		for(String value : values) {
			intValues[i] = Byte.valueOf(value).byteValue();
			//System.out.println("value i = " + value);
			i++;
		}

		StringBuilder sb = new StringBuilder();
		for(byte a = SMALLEST_LETTER; a < LARGEST_LETTER; a++) {
			int counter = 1;
			for(byte b = SMALLEST_LETTER; b < LARGEST_LETTER; b++) {
				for(byte c = SMALLEST_LETTER; c < LARGEST_LETTER; c++) {
					//System.out.println();
					//System.out.print("a = " + a);
					//System.out.print("b = " + b);
					for(int j = 0; j < intValues.length - 2; j += 3) {
						char char1 = (char) (intValues[j] ^ a);
						char char2 = (char) (intValues[j + 1] ^ b);
						char char3 = (char) (intValues[j + 2] ^ c);
						sb = sb.append(char1);
						sb = sb.append(char2);
						sb = sb.append(char3);
						//System.out.print("" + (char) char1 + (char) char2 + (char) char3);
						//intValues[j] = (byte) char1;
						//intValues[j + 1] = (byte) char2;
						//intValues[j + 2] = (byte) char3;
						counter++;
						if(counter == 1201) {
							if(containsWord(sb, "gospel")) {
								System.out.println();
								System.out.print("a = " + a);
								System.out.print("; b = " + b);
								System.out.println("; c = " + c);
								System.out.println(sb.toString());

								int nrOfSpaces = countNumberOfSpaces(sb);
								System.out.println("counter: " + counter);
								System.out.println();
							}
							counter = 1;
							sb = new StringBuilder();
							break;
						}
						if(!isLetter(char1) || !isLetter(char2) || !isLetter(char3)) {
							counter = 1;
							sb = new StringBuilder();
							break;
						}
					}
				}
			}
		}
	}

	private int countNumberOfSpaces(StringBuilder sb) {
		int spaces = 0;
		for(int i = 0; i < sb.length(); i++) {
			if(sb.charAt(i) == ' ')
				spaces++;
		}
		System.out.println("spaces = " + spaces);
		return spaces;
	}

	private boolean containsWord(StringBuilder sb, String word) {
		return sb.toString().toLowerCase().contains(word.toLowerCase());
	}

	private boolean isLetter(char i) {
		// any printable ASCII character
		return i >= 32 && i <= 126;
	}

	@Override public String getProblemName() {
		return "Problem 59: XOR decryption";
	}
}
