package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;

public class DateComparision {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the date in \"dd/MM/dddd\" format");
		String date = sc.nextLine();
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sdf = new  SimpleDateFormat(pattern);
		try {
			Date d = sdf.parse(date);
			Date d1 = sdf.parse(date);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
