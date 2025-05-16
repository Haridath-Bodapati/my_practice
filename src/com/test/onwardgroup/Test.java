//Jesus
package com.test.onwardgroup;

import java.security.SecureRandom;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Test {

//	Jesus

	public static void main(String[] args) throws Exception {

		/**
		 * On every run, the system should create 10 unique coupoun codes Each coupun
		 * should have one Capital and number Each coupon must be 10 Character Length.
		 */
		// String uniqueString = getCoupounCode();

		String timeColonPattern = "HH:mm:ss SSS";
		DateTimeFormatter timeColonFormatter = DateTimeFormatter.ofPattern(timeColonPattern);
		LocalTime colonTime = LocalTime.of(17, 35, 50).plus(329, ChronoUnit.MILLIS);
		LocalTime colonTime1 = LocalTime.now();
		System.out.println("************** colonTime "+ colonTime1);
		
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		System.out.println("Year is " + year);
		int month = calendar.get(Calendar.MONTH);
		System.out.println("MONTH is " + month);
		int date = calendar.get(Calendar.DATE);
		System.out.println("DATE is " + date);
		int hour = calendar.get(Calendar.HOUR);
		System.out.println("HOUR is " + hour);
		int minute = calendar.get(Calendar.MINUTE);
		System.out.println("MINUTE is " + minute);
		int second = calendar.get(Calendar.SECOND);
		System.out.println("SECOND is " + second);
		
		String ALPHABETS = "ABCDEFGHIJKLMNNOPQRSTUVWXYZ";
		SecureRandom random = new SecureRandom();
		random.nextInt(ALPHABETS.length());
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(year).substring(2)).append(month).append(date).append(hour).append(minute).append(second).append(ALPHABETS.charAt(random.nextInt(ALPHABETS.length())));
		System.out.println("************** Unique String is "+ sb.toString());
		System.out.println("************** Lenght is "+ sb.length());
		
		
		System.out.println(timeColonFormatter.format(colonTime));

		Map<Integer, String> couponsMap = new HashMap<>();

		for (int i = 0; i <= 9; i++) {
			couponsMap.put(i, getCoupounCode());
		}

		System.out.println("Coupouns :" + couponsMap);

		couponsMap.forEach((K, V) -> System.out.println("Key :" + K + "Value : " + V));

	}

	private static String getCoupounCode() throws Exception {
		StringBuffer sb = new StringBuffer();
		// This we can change to get new alphabet everytime
		sb.append("A");
		java.util.Date date = new java.util.Date();
		String uniqueString = String.valueOf(date.getTime());
		sb.append(uniqueString);
		sb.replace(3, 6, String.valueOf(Math.random()).substring(1, 4));

		System.out.print("Unique String is " + sb.toString());
		uniqueString.concat(String.valueOf(Math.random()));
		if (uniqueString.length() > 9) {
			sb = new StringBuffer(sb.substring(0, 10));
		}

		sb = new StringBuffer(sb.toString().replace(sb.charAt(sb.toString().indexOf(".")), '7'));
		System.out.println(" Returning unique string: " + sb.toString());

		return sb.toString();
	}

}
