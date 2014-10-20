package org.schoen.ben.euler.util;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.newBufferedReader;
import static java.nio.file.Paths.get;

import java.io.*;
import java.net.*;

import org.schoen.ben.euler.*;

public class FileUtil {

	public static BufferedReader readFile(String fileName) {
		URI uri;
		try {
			uri = EulerRunner.class.getResource(fileName).toURI();
			return newBufferedReader(get(uri), UTF_8);
		} catch(URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
