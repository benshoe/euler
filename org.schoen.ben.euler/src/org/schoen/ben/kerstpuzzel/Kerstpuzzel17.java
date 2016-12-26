package org.schoen.ben.kerstpuzzel;

import org.schoen.ben.euler.util.*;

import java.util.*;

/**
 * Created by ben on 24-12-16.
 */
public class Kerstpuzzel17 {

    public static final int[] ROOD = new int[]{1, 4, 7, 10, 13, 16, 19, 22, 25};
    public static final int[] GROEN = new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26};
    public static final int[] BLAUW = new int[]{3, 6, 9, 12, 15, 18, 21, 24};

    public static void main(String[] args) {
        Kerstpuzzel17 kerstpuzzel17 = new Kerstpuzzel17();
        kerstpuzzel17.run();
    }

    private void run() {
		boolean cont = true;
		while(cont) {
			Scanner reader = new Scanner(System.in);
			String code = readCode();
			int[] getallen = getValuesForRGB(reader);
			System.out.println("R = " + getallen[0]);
			System.out.println("G = " + getallen[1]);
			System.out.println("B = " + getallen[2]);

			int r = 0, g = 0, b = 0;
			for(char c : code.toUpperCase().toCharArray()) {
				switch(c){
					case 'R':
						r++;
						break;
					case 'G':
						g++;
						break;
					case 'B':
						b++;
						break;
					default:
						throw new IllegalArgumentException("No value found for: " + c);
				}
			}

			System.out.println("Rood");
			printPossibilities(getallen[0], ROOD, r);
			System.out.println("Groen");
			printPossibilities(getallen[1], GROEN, g);
			System.out.println("Blauw");
			printPossibilities(getallen[2], BLAUW, b);
			cont = continuePlaying(reader);
		}
	}

	private boolean continuePlaying(Scanner reader) {
		System.out.println("Wil je doorgaan? (J/N): ");
		String code = reader.next();
		return "J".equalsIgnoreCase(code);
	}

	private void printPossibilities(int sum, int[] denom, int aantal) {
		List<int[]> possibleArrays = new ArrayList<>();
		CombinationUtil.findAllCombinations(0, denom, sum, denom.clone(), possibleArrays);
		for(int[] array : possibleArrays) {
			if(aantal == foundValues(array)) {
				for(int i = 0; i < array.length; i++) {
					for(int j = 0; j < array[i]; j++) {
						System.out.print(ALPHABET.getLetter(denom[i]));
					}
				}
				System.out.println();
			}
		}
	}

	private int foundValues(int[] array) {
		int aantal = 0;
		for(int i = 0; i < array.length; i++) {
			aantal += array[i];
		}
		return aantal;
	}

	private int[] getValuesForRGB(Scanner reader) {
        int[] getallen = new int[3];
        System.out.println("Waardes RGB (bijv. 22 13 30): ");
        for(int i = 0; i < 3; i++) {
            getallen[i] = reader.nextInt();
        }
        return getallen;
    }

    private String readCode() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Code (bijv. BGBGR): ");
        String code = reader.next();
        if(!code.matches("[RGB]*")) {
            System.out.println("You entered invalid code: " + code);
            System.out.println("The code may only contain combinations of R G and B");
            readCode();
        }
        return code;
    }
}
