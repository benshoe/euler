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
		List<String> values = bufferedReader.lines().<String>flatMap(s -> Stream.of(s.split(","))).collect(Collectors.toList());
		System.out.println("values = " + values.size());
		System.out.println("values = " + values);
		byte[] intValues = new byte[values.size()];
		int i = 0;
		for(String value : values) {
			intValues[i] = Byte.valueOf(value).byteValue();
			//System.out.println("value i = " + value);
			i++;
		}

		byte a=  103;
		byte b = 111;
		byte c = 100;
		StringBuilder sb = new StringBuilder();
		//for(byte a = 103; a < 104; a++) {
			int answer = 46; //The final character from the string ;-)
			//for(byte b = 111; b < 112; b++) {
			//	for(byte c = 100; c < 101; c++) {
					//System.out.println();
					//System.out.print("a = " + a);
					//System.out.print("b = " + b);
					for(int j = 0; j < intValues.length - 1; j += 3) {
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
						answer+= char1;
						answer+= char2;
						answer+= char3;
						//if(answer == 1201) {
						//	if(containsWord(sb, "gospel")) {
							//}
							//answer = 1;
							//sb = new StringBuilder();
							//break;
						//}
						//if(!isLetter(char1) || !isLetter(char2) || !isLetter(char3)) {
						//	answer = 1;
						//	sb = new StringBuilder();
						//	break;
						//}
					}
				//}
			//}
		//}
		System.out.println();
		System.out.print("a = " + a);
		System.out.print("; b = " + b);
		System.out.println("; c = " + c);
		System.out.println(sb.toString());
		System.out.println("sb.toString().length() = " + sb.toString().length());
		setAnswer(String.valueOf(answer));
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
