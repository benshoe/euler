package org.schoen.ben.euler.util;

import java.util.regex.*;

/**
 * @author <a href="mailto:ben.schoen@ns.nl">Ben Schoen</a>
 * @since 20-12-20.
 */
public class CharacterUtil {

	public static boolean heeftRepeatingChars(String woord) {
		Pattern repeatingChars = Pattern.compile("(\\w)\\1+");
		Matcher matcher = repeatingChars.matcher(woord);
		return matcher.find();
	}

	public static boolean heeftAlleenMedeklinkers(String woord) {
		Pattern klinkers = Pattern.compile("[AEIOU]");
		Matcher matcher = klinkers.matcher(woord);
		return !matcher.find();
	}
}
