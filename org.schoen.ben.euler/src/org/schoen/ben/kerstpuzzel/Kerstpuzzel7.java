package org.schoen.ben.kerstpuzzel;

/**
 * Created by ben on 16-12-16.
 */
public class Kerstpuzzel7 {

    TextRotator m_rotator = new TextRotator();

    public static void main(String[] args) {
        Kerstpuzzel7 kerstpuzzel7 = new Kerstpuzzel7();
        kerstpuzzel7.run4();
    }

    private void run() {
        TextRotator textRotator = new TextRotator();
        String text = "xbucfhpobmtffosvuvkigtqvdwlhzptvroxamdiyvdlnaoxkddgo";
        m_rotator.printRotatedText(text);

        text = "tvroxamdiyvdlnaoxkddgo";
//        for(int j = 0; j < 26; j++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                System.out.print(text.substring(i, i + 1) + " : ");
                int shift = (int) (-1 * (Math.pow(2, i+1)));
                System.out.println("shift = " + shift);
                sb.append(textRotator.rotateText(text.substring(i, i + 1), shift));
            }
            m_rotator.printRotatedText(sb.toString());
//        }

//        text = "gevtnfi iomw mjjggqhibrdop qfmuxlhsd jb uz yndxxn wckd";
//        printRotatedText(textRotator, text);
    }

    private void run2() {
        TextRotator textRotator = new TextRotator();
        String text = "xbucfhpobmtffosvuvkigtqvdwlhzptvroxamdiyvdlnaoxkddgo";
        int counter = 0;
        int shift = 25;
        while(counter < 16) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        printTussenresultaat(counter, shift);
        shift--;
        while(counter < 24) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        printTussenresultaat(counter, shift);
        shift--;
        while(counter < 28) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        printTussenresultaat(counter, shift);
        shift--;
        while(counter < 30) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        printTussenresultaat(counter, shift);
        shift--;
        while(counter < 31) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        printTussenresultaat(counter, shift);
        shift -= 2;
        int i = 2;
        while(counter < 33) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
            shift = (int) (shift - Math.pow(2, i));
            i++;
        }
        printTussenresultaat(counter, shift);
        shift -= 10;
        i = 2;
        while(counter < text.length()) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
            shift = (int) (shift - Math.pow(2, i));
            //i++;
        }
    }

    private void run3() {
        TextRotator textRotator = new TextRotator();
        String text = "xbucfhpobmtffosvuvkigtqvdwlhzptvroxamdiyvdlnaoxkddgo";
        int counter = 0;
        int shift = 25;
        System.out.println(" shift = " + shift);
        while(counter < 16) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        shift--;
        printTussenresultaat(counter, shift);
        while(counter < 24) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        shift--;
        printTussenresultaat(counter, shift);
        while(counter < 28) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        shift--;
        printTussenresultaat(counter, shift);
        while(counter < 30) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        shift--;
        printTussenresultaat(counter, shift);
        while(counter < 31) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        shift -= 2;
        printTussenresultaat(counter, shift);
        while(counter < 33) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
            shift -= 4;
        }
        shift -= 4;
        printTussenresultaat(counter, shift);
        m_rotator.printRotatedText(text.substring(counter));
        while(counter < 37) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
//            shift -= 16;
        }
        shift -= 10;
        printTussenresultaat(counter, shift);
        while(counter < text.length()) {
//            printRotatedCharacter(textRotator, text, counter, shift);
            shift -= 16;
            counter++;
        }
    }

    private void run4() {
        TextRotator textRotator = new TextRotator();
        String text = "xbucfhpobmtffosvuvkigtqvdwlhzptvroxamdiyvdlnaoxkddgo";
        int counter = 0;
        int shift = 25;
        //System.out.println(" shift = " + shift);
        counter = uncypher(textRotator, text, counter, shift,16);

        shift = 24;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 24);

        shift = 23;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 28);

        shift = 22;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 30);

        shift = 21;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 31);

        shift -= 2;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 32);

        shift -= 4;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 33);

        shift -= 8;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 34);

        shift -= 16;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 35);

        shift -= 32;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 36);

        shift -= 64;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 37);

        shift -= 128;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 38);

        shift -= 256;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 39);

        shift -= 512;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 40);

        shift -= 1024;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 41);

        shift -= 2048;
        printTussenresultaat(counter, shift);
        counter = uncypher(textRotator, text, counter, shift, 42);
        
        shift -= 4;
        printTussenresultaat(counter, shift);
        m_rotator.printRotatedText(text.substring(counter));
        while(counter < 37) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
//            shift -= 16;
        }
        shift -= 10;
        printTussenresultaat(counter, shift);
        while(counter < text.length()) {
//            printRotatedCharacter(textRotator, text, counter, shift);
            shift -= 16;
            counter++;
        }
    }

    private int uncypher(TextRotator textRotator, String text, int counter, int shift, int limit) {
        while(counter < limit) {
            printRotatedCharacter(textRotator, text, counter, shift);
            counter++;
        }
        return counter;
    }

    private void printTussenresultaat(int counter, int shift) {
        System.out.println();
//        System.out.println("Aantal karakters: " + (counter));
//        System.out.println("Karakters te gaan: " + (52 - counter));
//        System.out.println(" shift = " + shift);
    }

    private void printRotatedCharacter(TextRotator textRotator, String text, int counter, int shift) {
        System.out.print(textRotator.rotateText(text.substring(counter, counter + 1), shift));
    }

    private void run7b() {
        String text = "gevtnfiiomwmjjggqhibrdopqfmuxlhsdjbuzyndxxnwckd";
        TextRotator textRotator = new TextRotator();
        int shift = -1;
        for(int i = 0; i < text.length(); i++) {
            printRotatedCharacter(textRotator, text, i, 8);
        }
        System.out.println();
        m_rotator.printRotatedText(text);
    }

}
