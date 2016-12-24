package org.schoen.ben.kerstpuzzel;

import java.util.Scanner;

/**
 * Created by ben on 24-12-16.
 */
public class Kerstpuzzel18 {

    private final int[] rood = new int[]{1, 4, 7, 10, 13, 16, 19, 22, 25};
    private final int[] groen = new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26};
    private final int[] blauw = new int[]{3, 6, 9, 12, 15, 18, 21, 24};

    public static void main(String[] args) {
        Kerstpuzzel18 kerstpuzzel18 = new Kerstpuzzel18();
        kerstpuzzel18.run();
    }

    private void run() {
        Scanner reader = new Scanner(System.in);
        String code = readCode();
        int[] getallen = getValuesForRGB(reader);
        System.out.println("R = " + getallen[0]);
        System.out.println("G = " + getallen[1]);
        System.out.println("B = " + getallen[2]);

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
