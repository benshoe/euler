package org.schoen.ben.euler.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ben on 08-01-17.
 */
public final class ImprobableWordRemover {

    public void removeImprobableWords(List<String> words) {
        List<String> wordList = new ArrayList<>(words);
        for (String word : wordList) {
            int countMedeklinkers = 0;
            for (int i = 0; i < word.length(); i++) {
                if(isKlinker(word.charAt(i))) {
                    countMedeklinkers = 0;
                } else {
                    countMedeklinkers++;
                }
                if(countMedeklinkers > 2) {
                    words.remove(word);
                }
            }
        }
    }

    private boolean isKlinker(char c) {
        return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public void removeImprobableLetterCombinations(List<String> words) {
        List<String> wordList = new ArrayList<>(words);
        for(String word : wordList) {
            for (int i = 0; i < word.length() - 1; i++) {
                if (isOnlogischeCombi(word.substring(i))) {
                    words.remove(word);
                    break;
                }
                if(isLetterWaarGeenMedeklinkerAchterPast(word.charAt(i))) {
                    if (isKlinker(word.charAt(i + 1))) {
                        // geen probleem, want een klinker na deze letter
                    } else {
                        words.remove(word);
                    }
                }
            }
        }
    }

    private boolean isOnlogischeCombi(String s) {
        return s.contains("BC") || s.contains("KUE") || s.contains("CW") || s.contains("BF") || s.contains("CZ") || s.contains("UUE");
    }

    private boolean isLetterWaarGeenMedeklinkerAchterPast(char c) {
        return c == 'X' || c == 'Z';
    }
}
