package org.schoen.ben.kerstpuzzel;

import java.math.*;
import java.util.*;

/**
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since 5-1-19.
 */
public class Kerst2018Opg10 {

	public static void main(String[] args) {
		Kerst2018Opg10 opg10 = new Kerst2018Opg10();
		opg10.run();
	}

	private void run() {
		//List<BigInteger> factors1 = FactorUtil.getFactors(new BigInteger("2231"));
		//System.out.println("factors 2231 = " + factors1);
		//System.out.println("aantalMilliseconden = " + (System.currentTimeMillis() - currentTimeMillis));
		//currentTimeMillis = System.currentTimeMillis();
		//List<BigInteger> factors2 = FactorUtil.getFactors(new BigInteger("11371"));
		//System.out.println("factors 11371 = " + factors2);
		//System.out.println("aantalMilliseconden = " + (System.currentTimeMillis() - currentTimeMillis));
		//currentTimeMillis = System.currentTimeMillis();
		//List<BigInteger> factors3 = FactorUtil.getFactors(new BigInteger("2165299"));
		//System.out.println("factors 2165299 = " + factors3);
		//System.out.println("aantalMilliseconden = " + (System.currentTimeMillis() - currentTimeMillis));
		//currentTimeMillis = System.currentTimeMillis();
		//List<BigInteger> factors4 = FactorUtil.getFactors(new BigInteger("131027147"));
		//System.out.println("factors 131027147 = " + factors4);
		//System.out.println("aantalMilliseconden = " + (System.currentTimeMillis() - currentTimeMillis));
		//currentTimeMillis = System.currentTimeMillis();
		//List<BigInteger> factors5 = FactorUtil.getFactors(new BigInteger("175536811"));
		//System.out.println("factors 175536811" + factors5);
		//System.out.println("aantalMilliseconden = " + (System.currentTimeMillis() - currentTimeMillis));
		//currentTimeMillis = System.currentTimeMillis();
		//List<BigInteger> factors6 = FactorUtil.getFactors(new BigInteger("181493911"));
		//System.out.println("factors 181493911" + factors6);
		//System.out.println("aantalMilliseconden = " + (System.currentTimeMillis() - currentTimeMillis));
		//currentTimeMillis = System.currentTimeMillis();
		//List<BigInteger> factors7 = FactorUtil.getFactors(new BigInteger("10971260147"));
		//System.out.println("factors 10971260147" + factors7);
		//System.out.println("aantalMilliseconden = " + (System.currentTimeMillis() - currentTimeMillis));
		//currentTimeMillis = System.currentTimeMillis();
		//List<BigInteger> factors8 = FactorUtil.getFactors(new BigInteger("715140684628284199"));
		//System.out.println("factors 715140684628284199" + factors8);
		//System.out.println("aantalMilliseconden = " + (System.currentTimeMillis() - currentTimeMillis));
		//currentTimeMillis = System.currentTimeMillis();

		BigInteger grootGetal1 = new BigInteger("27799359960895951622945294228650160556473581133507282258716324517526331387881422051374048992068531165469465793");
		//BigInteger grootGetal1 = new BigInteger("612242109049354757693703731756141884122575855425310699918367263271480642730811111952684256523677275662759320997");

		//grootGetal1 = new BigInteger("10971260147");
		while(true) {
			String deler = readCode();

			StringBuilder sb = new StringBuilder(deler);
			deler = sb.reverse().toString();
			String dezeDeler = deler;
			int length = deler.length();
			for(int i = 0; i <= length - 1; i++) {
				controleerString(grootGetal1, dezeDeler);
				dezeDeler = deler.substring(0, length - i - 1);
				System.out.println("dezeDeler = " + dezeDeler);
			}
		}
	}

	private void controleerString(BigInteger grootGetal1, String deler) {
		int length = deler.length();
		System.out.println("Je deler is: " + deler);
		for(int i = 0; i <= length; i++) {
			System.out.println("deler = " + deler);
			if(deler.length() == 1 || deler.equals("01")) {
				break;
			}
			controleerDeler(grootGetal1, deler);
			deler = deler.substring(1);
		}
	}

	private void controleerDeler(BigInteger grootGetal1, String deler) {
		BigInteger[] bigIntegers = grootGetal1.divideAndRemainder(new BigInteger(deler));
		if(bigIntegers[1].equals(BigInteger.ZERO)) {
			System.out.println(deler + " een deler van " + grootGetal1);
			System.out.println("De andere factor is: " + bigIntegers[0]);
			System.exit(10);
		} else {
			System.out.println(deler + " is geen deler van " + grootGetal1);
		}
	}

	private String readCode() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Geef de deler op: ");
		return reader.next();
	}
}
