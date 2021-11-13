package org.schoen.ben.kerstpuzzel;

import java.util.*;

import org.schoen.ben.euler.util.*;

public class Kerstpuzzel2020Nr11D {

	public static void main(String[] args) {
		Kerstpuzzel2020Nr11D kerstpuzzel2020Nr11 = new Kerstpuzzel2020Nr11D();
		kerstpuzzel2020Nr11.run();
	}

	private void run() {
		String woord1 = "";
		String woord2 = "";
		int letterafwijking1 = -11;
		int letterafwijking2 = -3;
		int letterafwijking3 = -14;
		int letterafwijking4 = 2;
		int letterafwijking5 = 2;
		int letterafwijking6 = -11;
		int letterafwijking7 = 1;
		int letterafwijking8 = 4;
int counter = 0;
		for(int letter1 = 65; letter1 < 80; letter1++) {
			for(int letter2 = 65; letter2 < 88; letter2++) {
				for(int letter3 = 65; letter3 < 77; letter3++) {
					for(int letter4 = 67; letter4 < 91; letter4++) {
					//	for(int letter5 = 67; letter5 < 91; letter5++) {
							//for(int letter6 = 65; letter6 < 91; letter6++) {
							//	if(letter6 - letterafwijking6 < 65 || letter6 - letterafwijking6 > 91) {					continue;				}
							//	for(int letter7 = 65; letter7 < 91; letter7++) {
							//		if(letter7 - letterafwijking7 < 65 || letter7 - letterafwijking7 > 91) {					continue;				}
							//		for(int letter8 = 65; letter8 < 91; letter8++) {
							//			if(letter8 - letterafwijking8 < 65 || letter8 - letterafwijking8 > 91) {					continue;				}
										char letter11 = (char) letter1;
										char letter12 = (char) letter2;
										char letter13 = (char) letter3;
										char letter14 = (char) letter4;
										//char letter15 = (char) letter5;
										//char letter16 = (char) letter6;
										//char letter17 = (char) letter7;
										//char letter18= (char) letter8;

										char letter21 = (char) (letter1 - letterafwijking1);
										char letter22 = (char) (letter2 - letterafwijking2);
										char letter23 = (char) (letter3 - letterafwijking3);
										char letter24 = (char) (letter4 - letterafwijking4);
										//char letter25 = (char) (letter5 - letterafwijking5);
										//char letter26 = (char) (letter6 - letterafwijking6);
										//char letter27 = (char) (letter7 - letterafwijking7);
										//char letter28 = (char) (letter8 - letterafwijking8);
										woord1 = String.valueOf(letter11) + letter12 + letter13 + letter14;// + letter15;// + letter16 + letter17 + letter18;
										woord2 = String.valueOf(letter21) + letter22 + letter23 + letter24;// + letter25;// + letter26 + letter27 + letter28;


						if(logischWoord(woord1, woord2) && woord1.equals("ELEK")) {
							System.out.println(woord1 + "   " + woord2);
							counter++;
						}}
									}
								}
							//}
						//}
					//}
				}
		System.out.println("Aantal woorden = " + counter);
			//}
		}

	private boolean logischWoord(String woord1, String woord2) {
		if(heeftDrieGelijkeLetters(woord1) || heeftDrieGelijkeLetters(woord2)) {
			return false;
		}
		if(CharacterUtil.heeftAlleenMedeklinkers(woord1) || CharacterUtil.heeftAlleenMedeklinkers(woord2)) {
			return false;
		}


		if(bevatRareCombinatie(woord1, woord2)) {
			return false;
		}
		return true;
	}

	private boolean bevatRareCombinatie(String woord1, String woord2) {
		return Arrays.stream(RARE_COMBINATIES.values()).anyMatch(combi -> woord1.contains(combi.name()) || woord2.contains(combi.name()));
		//if(woord1.contains("ZV") || woord2.contains("ZV")) {
		//	return false;
		//}
		//if(woord1.contains("Q") || woord2.contains("Q")) {
		//	return false;
		//}
		//return false;
	}

	private boolean heeftDrieGelijkeLetters(String woord) {
		return CharacterUtil.heeftRepeatingChars(woord);
	}
}

