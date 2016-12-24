package org.schoen.ben.kerstpuzzel;

import static java.lang.Character.isLowerCase;

/**
 * Created by ben on 16-12-16.
 */
public class TextRotator {

    public String rotateText(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        int length = text.length();
        char[] chars = text.toCharArray();
        for(int i = 0; i < length; i++) {
            sb.append(findChar(chars[i], shift));
        }
        return sb.toString();
    }

    private char findChar(char c, int pos) {
        if(c == ' ') {
            return ' ';
        }
        if (c == ',') {
            return ',';
        }
        int shift = c + pos;
        if(isLowerCase(c)) {
            shift = createValidLowercaseValue(shift);
            return Character.toChars(shift)[0];
        }

        shift = createValidUppercaseValue(shift);
        return Character.toChars(shift)[0];
    }

    private int createValidLowercaseValue(int shift) {
        while(shift > 122) {
            shift -= 26;
        }
        while(shift < 97) {
            shift += 26;
        }
        return shift;
    }

    private int createValidUppercaseValue(int shift) {
        while(shift > 90) {
            shift -= 26;
        }
        while(shift < 65) {
            shift += 26;
        }
        return shift;
    }

    public void printRotatedText(String text) {
        for(int i = 0; i < 26; i++) {
            System.out.printf("%2d : " + rotateText(text, i), i).println();
        }
    }

}
