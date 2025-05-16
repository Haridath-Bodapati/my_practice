package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CompareTwoDays {

	public static void main(String[] args) throws ParseException {
		
		/*Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();*/
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fromDate = sdf.parse("2015-05-01");
		Date toDate = sdf.parse("2015-05-07");

		// Days.daysBetween(start, end).getDays();
		Calendar c = Calendar.getInstance();
		c.setTime(fromDate);
		c.add(Calendar.DATE, 7);
		int compareVal = c.getTime().compareTo(toDate);
		
		if (compareVal == 0) {
			// It's more than 7 days.
			System.out.println("From Date is same after 7 days to todate");
		} else if (compareVal > 0) {
			// It's more than 7 days.
			System.out.println("From Date is greater after 7 days to todate");
		} else if (compareVal < 0) {
			// It's more than 7 days.
			System.out.println("From Date is lesser after 7 days to todate");
		}
	}
}
