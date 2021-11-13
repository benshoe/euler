package org.schoen.ben.kerstpuzzel;

import java.math.*;
import java.time.*;
import java.util.*;

/**
 * @author <a href="mailto:benshoe@gmail.com">Ben Schoen</a>
 * @since 31-12-20.
 */
public class Kerstpuzzel2020Nr24 {

	public static void main(String[] args) {
		Kerstpuzzel2020Nr24 nr13 = new Kerstpuzzel2020Nr24();
		nr13.run();
	}

	private void run() {
		BigInteger getal01 = BigInteger.valueOf(1040519640);
		BigInteger getal02 = BigInteger.valueOf(1072076640);
		BigInteger getal03 = BigInteger.valueOf(1103632920);
		BigInteger getal04 = BigInteger.valueOf(1135190100);
		BigInteger getal05 = BigInteger.valueOf(1166746920);
		BigInteger getal06 = BigInteger.valueOf(1198303680);
		BigInteger getal07 = BigInteger.valueOf(1229861040);
		BigInteger getal08 = BigInteger.valueOf(1261417620);
		BigInteger getal09 = BigInteger.valueOf(1292974680);
		BigInteger getal10 = BigInteger.valueOf(1324531800);
		BigInteger getal11 = BigInteger.valueOf(1356088260);
		BigInteger getal12 = BigInteger.valueOf(1387645860);
		BigInteger getal13 = BigInteger.valueOf(1419202980);
		BigInteger getal14 = BigInteger.valueOf(1450759680);
		BigInteger getal15 = BigInteger.valueOf(1482317040);
		BigInteger getal16 = BigInteger.valueOf(1513873680);
		BigInteger getal17 = BigInteger.valueOf(1545430980);
		BigInteger getal18 = BigInteger.valueOf(1576988340);

		List<BigInteger> getallen = Arrays.asList(getal01, getal02, getal03, getal04, getal05, getal06, getal07, getal08, getal09, getal10, getal11,
			getal12, getal13, getal14, getal15, getal16, getal17, getal18);

		getallen.stream().map(BigInteger::longValue).peek(aLong -> System.out.println("aLong = " + LocalDateTime.ofEpochSecond(aLong, 0, ZoneOffset.UTC))).count();
	}

}
