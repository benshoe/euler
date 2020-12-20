package org.schoen.ben.kerstpuzzel;

public class Kerstpuzzel2020Nr17 {

	public static void main(String[] args) {
		Kerstpuzzel2020Nr17 kerstpuzzel2020Nr17 = new Kerstpuzzel2020Nr17();
		kerstpuzzel2020Nr17.run();
	}

	private void run() {
		String woord1 = "";
		String woord2 = "";
		int letterafwijking1 = 0;
		int letterafwijking2 = 3;
		int letterafwijking3 = 8;
		int letterafwijking4 = 13;
		int letterafwijking5 = 2;
		int letterafwijking6 = -11;
		int letterafwijking7 = 1;
		int letterafwijking8 = 4;

		for(int letter1 = 65; letter1 < 91; letter1++) {
			for(int letter2 = 65; letter2 < 91; letter2++) {
				if(letter2 - letterafwijking2 < 65 || letter2 - letterafwijking2 > 91) {					continue;				}
				for(int letter3 = 65; letter3 < 91; letter3++) {
					if(letter3 - letterafwijking3 < 65 || letter3 - letterafwijking3 > 91) {					continue;				}
					for(int letter4 = 65; letter4 < 91; letter4++) {
						if(letter4 - letterafwijking4 < 65 || letter4 - letterafwijking4 > 91) {					continue;				}
						for(int letter5 = 65; letter5 < 91; letter5++) {
							if(letter5 - letterafwijking5 < 65 || letter5 - letterafwijking5 > 91) {					continue;				}
							for(int letter6 = 65; letter6 < 91; letter6++) {
								if(letter6 - letterafwijking6 < 65 || letter6 - letterafwijking6 > 91) {					continue;				}
								for(int letter7 = 65; letter7 < 91; letter7++) {
									if(letter7 - letterafwijking7 < 65 || letter7 - letterafwijking7 > 91) {					continue;				}
									for(int letter8 = 65; letter8 < 91; letter8++) {
										if(letter8 - letterafwijking8 < 65 || letter8 - letterafwijking8 > 91) {					continue;				}
										char letter11 = (char) letter1;
										char letter12 = (char) letter2;
										char letter13 = (char) letter3;
										char letter14 = (char) letter4;
										char letter15 = (char) letter5;
										char letter16 = (char) letter6;
										char letter17 = (char) letter7;
										char letter18= (char) letter8;

										char letter21 = (char) letter1;
										char letter22 = (char) (letter2 - letterafwijking2);
										char letter23 = (char) (letter3 - letterafwijking3);
										char letter24 = (char) (letter4 - letterafwijking4);
										char letter25 = (char) (letter5 - letterafwijking5);
										char letter26 = (char) (letter6 - letterafwijking6);
										char letter27 = (char) (letter7 - letterafwijking7);
										char letter28 = (char) (letter8 - letterafwijking8);
										woord1 = String.valueOf(letter11) + letter12 + letter13 + letter14 + letter15 + letter16 + letter17 + letter18;
										woord2 = String.valueOf(letter21) + letter22 + letter23 + letter24 + letter25 + letter26 + letter27 + letter28;



										System.out.println(woord1 + "   " +woord2);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

