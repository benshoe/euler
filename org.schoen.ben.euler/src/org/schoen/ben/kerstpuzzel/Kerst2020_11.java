package org.schoen.ben.kerstpuzzel;

import java.util.*;
import java.util.stream.*;

/**
 * @author <a href="mailto:ben.schoen@ns.nl">Ben Schoen</a>
 * @since 15-12-20.
 */
public class Kerst2020_11 {

	public static void main(String[] args) {
		Kerst2020_11 kerst2020_11 = new Kerst2020_11();
		kerst2020_11.run();
	}

	private void run() {
		String puzzle = "0 3 7 13 2 -13 1 4";
		List<Integer> letterAfstanden = Stream.of(puzzle.split(" ")).map(Integer::valueOf).collect(Collectors.toList());

		maakWoorden(letterAfstanden);

	}

	private void maakWoorden(List<Integer> letterAfstanden) {
		int ch = 'A';
		System.out.println("ch = " + ch);
		char b = (char) ch;
		System.out.println("b = " + b);

		String woord1 = "";
		String woord2 = "";
		for(Integer afstand : letterAfstanden) {
			for(char letter = 'A'; letter <= 'Z'; letter++) {
				int letterWoord1 = letter;
				int letterWoord2 = letterWoord1 - afstand;
				if(letterWoord2 < 65 || letterWoord2 > (91)) {
					break;
				}
				woord1 = woord1.concat(String.valueOf((char) letterWoord1));
				woord2 = woord2.concat(String.valueOf((char) letterWoord2));
			}
		}
		System.out.println(woord1 + " " + woord2);

	}
}
