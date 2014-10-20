package org.schoen.ben.euler;

import java.util.*;

public class Problem019 extends AbstractEulerProblem {

	public Problem019(String answer) {
		super(answer);
	}

	@Override
	public void run() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1901);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Calendar endDate = Calendar.getInstance();
		endDate.set(Calendar.YEAR, 2000);
		endDate.set(Calendar.MONTH, 11);
		endDate.set(Calendar.DAY_OF_MONTH, 31);
		endDate.set(Calendar.HOUR_OF_DAY, 0);
		endDate.set(Calendar.MINUTE, 0);
		endDate.set(Calendar.SECOND, 0);
		endDate.set(Calendar.MILLISECOND, 0);

		int sundays = 0;
		while(cal.before(endDate)) {
			cal.add(Calendar.MONTH, 1);
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				sundays++;
		}
		setAnswer(String.valueOf(sundays));
	}

	@Override
	public String getProblemName() {
		return "Problem 19: How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?";
	}

}
