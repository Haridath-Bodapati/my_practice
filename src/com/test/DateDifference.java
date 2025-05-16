package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDifference {

	public static void main(String[] args) {
		try{
			/*Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the number :");
			int inta = scanner.nextInt();
			System.out.println("Entered number is 1 :"+inta);			
			System.out.println("Enter the number 2:");
			int intb = scanner.nextInt();
			System.out.println("Entered number is 2 :"+intb);
			
			System.out.println("Sum value is "+(inta+intb));
			*/
			
			System.out.println("Enter the date in MM/dd/YYYY format");
			String pattern = "MM/dd/yyyy";
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			
			try{
				Scanner s = new Scanner(System.in);
				String strDate = s.nextLine();
				Date date = sdf.parse(strDate);
				System.out.println("Entered date is "+date);
				
				System.out.println("Enter second date in MM/DD/YYYY format");
				String strDate1 = s.nextLine();
				Date date1 = sdf.parse(strDate1);
				System.out.println("Entered date1 is "+date1);
				
				if(date.after(date1)){
					long diff = date.getTime()-date1.getTime();
					
					int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		            System.out.println("difference between days: " + diffDays);
					//System.out.println("The diference in days is "+(int)(diff/24*60*60*1000));
				} else {
					long diff = date.getTime()-date1.getTime();
					int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		            System.out.println("difference between else days: " + diffDays);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
		}catch(Exception e){
			System.out.println("Please enter only numbers ");
			
		}
		

	}

}
