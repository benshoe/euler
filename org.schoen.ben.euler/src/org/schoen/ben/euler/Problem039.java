package org.schoen.ben.euler;

import java.util.*;
import java.util.Map.Entry;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three solutions for p = 120.
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 *
 *
 * @author <a href="mailto:ben.schoen@itris.nl">Ben Schoen</a>
 * @since Nov 7, 2014
 */
public class Problem039 extends AbstractEulerProblem {

	public Problem039(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		Map<Integer, Integer> triangles = new HashMap<>(1000);
		for(int i = 3; i <= 1000; i++) {
			triangles.put(new Integer(i), new Integer(0));
		}
		for(int a = 1; a < 400; a++) {
			for(int b = 1; b < 400; b++) {
				for(int c = 1; c < 400; c++) {
					if(a + b + c > 1000)
						break;
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
						Integer key = new Integer(a + b + c);
						Integer numberFound = triangles.get(key);
						triangles.put(key, new Integer(numberFound.intValue() + 1));
					}
				}
			}
		}
		Set<Entry<Integer, Integer>> entrySet = triangles.entrySet();
		int maxTriangles = 0;
		int triangle = 0;
		for(Entry<Integer, Integer> entry : entrySet) {
			if(entry.getValue().intValue() > maxTriangles) {
				maxTriangles = entry.getValue().intValue();
				triangle = entry.getKey().intValue();
				System.out.println(triangle + ": " + maxTriangles);
			}

		}
		setAnswer(String.valueOf(triangle));
	}

	@Override
	public String getProblemName() {
		return "Problem 39: For which value of p ≤ 1000, is the number of solutions maximised?";
	}

}
