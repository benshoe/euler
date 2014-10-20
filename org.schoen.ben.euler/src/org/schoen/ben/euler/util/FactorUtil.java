package org.schoen.ben.euler.util;

import java.util.*;

public class FactorUtil {

	public static Integer getSumOfFactors(int i) {
		List<Integer> factors = getFactors(i);
		int sum = 0;
		for(Integer integer : factors) {
			sum += integer.intValue();
		}
		return Integer.valueOf(sum);
	}

	private static List<Integer> getFactors(int i) {
		List<Integer> factors = new ArrayList<>();
		factors.add(new Integer("1"));
		int sqr = (int) Math.sqrt(i) + 1;
		for(int x = 2; x < sqr; x++) {
			int factor = i / x;
			if(i % x == 0) {
				factors.add(new Integer(x));
				if(x != factor) {
					factors.add(new Integer(factor));
				}
			}
		}
		return factors;
	}

}
