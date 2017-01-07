package org.schoen.ben.kerstpuzzel;

import org.schoen.ben.euler.util.*;

import java.util.*;

/**
 * Created by ben on 24-12-16.
 */
public class Kerstpuzzel17 {

    Map<String, List<String>> m_letterCombinationMap = new HashMap<>();

    public static final int[] ROOD = new int[]{1, 4, 7, 10, 13, 16, 19, 22, 25};
    public static final int[] GROEN = new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26};
    public static final int[] BLAUW = new int[]{3, 6, 9, 12, 15, 18, 21, 24};
    private List<String> m_words = new ArrayList<>();

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

			List<int[]> possibleRoodArrays = new ArrayList<>();
			CombinationUtil.findAllCombinations(0, ROOD, getallen[0], ROOD.clone(), possibleRoodArrays);
			List<int[]> possibleGroenArrays = new ArrayList<>();
			CombinationUtil.findAllCombinations(0, GROEN, getallen[1], GROEN.clone(), possibleGroenArrays);
			List<int[]> possibleBlauwArrays = new ArrayList<>();
			CombinationUtil.findAllCombinations(0, BLAUW, getallen[2], BLAUW.clone(), possibleBlauwArrays);

			possibleRoodArrays = removeImpossibleArrays(possibleRoodArrays, r);
			possibleGroenArrays = removeImpossibleArrays(possibleGroenArrays, g);
			possibleBlauwArrays = removeImpossibleArrays(possibleBlauwArrays, b);

			List<String> roodLetters = getLetters(possibleRoodArrays, ROOD);
			List<String> groenLetters = getLetters(possibleGroenArrays, GROEN);
			List<String> blauwLetters = getLetters(possibleBlauwArrays, BLAUW);
            m_letterCombinationMap.put("R", new ArrayList<>());
            for(String letters : roodLetters) {
                List<String> rood = Arrays.asList(PermutationUtil.getPermutations(letters));
                List<String> roodList = m_letterCombinationMap.get("R");
                roodList.addAll(rood);
			}

            m_letterCombinationMap.put("G", new ArrayList<>());
            for(String letters : groenLetters) {
                List<String> groen = Arrays.asList(PermutationUtil.getPermutations(letters));
                List<String> groenList = m_letterCombinationMap.get("G");
                groenList.addAll(groen);
            }

            m_letterCombinationMap.put("B", new ArrayList<>());
            for(String letters : blauwLetters) {
                List<String> blauw = Arrays.asList(PermutationUtil.getPermutations(letters));
                List<String> blauwList = m_letterCombinationMap.get("B");
                blauwList.addAll(blauw);
            }

			findPossibilities(code);
            m_words.sort(Comparator.naturalOrder());
            int counter = 0;
            for (String word : m_words) {
                System.out.println(counter++ + ": " + word);
            }

			cont = continuePlaying(reader);
		}
	}

    private void findPossibilities(String code) {
        for (String roodLetters : m_letterCombinationMap.get("R")) {
            for (String groenLetters : m_letterCombinationMap.get("G")) {
                for (String blauwLetters : m_letterCombinationMap.get("B")) {
                    addPossibility(code, roodLetters, groenLetters, blauwLetters);
                }
            }
        }
    }

    private List<String> getLetters(List<int[]> possibleRoodArrays, int[] denom) {
		List<String> letterList = new ArrayList<>();
		for(int[] array : possibleRoodArrays) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < array.length; i++) {
				for(int j = 0; j < array[i]; j++) {
					sb.append(ALPHABET.getLetter(denom[i]));
				}
			}
			letterList.add(sb.toString());
		}
		return letterList;
	}

	private List<int[]> removeImpossibleArrays(List<int[]> arrays, int aantal) {
		List<int[]> newArray = new ArrayList<>();
		for(int[] array : arrays) {
			if(aantal == foundValues(array)) {
				newArray.add(array);
			}
		}
		return newArray;
	}

	private boolean continuePlaying(Scanner reader) {
		System.out.println("Wil je doorgaan? (J/N): ");
		String code = reader.next();
		return "J".equalsIgnoreCase(code);
	}

	private void addPossibility(String code, String roodLetters, String groenLetters, String blauwLetters) {
		StringBuilder sb = new StringBuilder();
		int counter = 0;
    	int r = 0;
    	int g = 0;
    	int b = 0;
		for(int i = 0; i < code.length(); i++) {
			switch (code.charAt(counter)) {
				case 'R':
					sb.append(roodLetters.charAt(r));
					r++;
					break;
				case 'G':
					sb.append(groenLetters.charAt(g));
					g++;
					break;
				case 'B':
					sb.append(blauwLetters.charAt(b));
					b++;
					break;
				default:
					throw new IllegalArgumentException("Deze letter ken ik niet.");
			}
			counter++;
		}
        m_words.add(sb.toString());
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
