package com.test.collection;

import java.util.HashSet;
import java.util.Set;

public class CanAddDuplicateValueInSet {	
	
	public static void main(String[] args) {
		
		Set<String> uniqueColours = new HashSet();
		
		uniqueColours.add("Red");
		uniqueColours.add("Green");
		uniqueColours.add("Blue");
		System.out.println("Size of list is :"+ uniqueColours.size());
		uniqueColours.add("Blue"); /*Adding duplicate value here, 
		No compiler error and code works fine but doesn't add duplicate value */
		System.out.println("Size of list is :"+ uniqueColours.size());
		boolean returnVal = uniqueColours.add(null);
		System.out.println("Size of list is :"+ uniqueColours.size());
		System.out.println("returnVal :"+ returnVal);
		boolean returnVal1 = uniqueColours.add(null);
		System.out.println("returnVal1 :"+ returnVal1);
		System.out.println("Size of list is :"+ uniqueColours.size());
		returnVal = uniqueColours.add("null");
		System.out.println("Size of list is :"+ uniqueColours.size());
		System.out.println("returnVal :"+ returnVal);
		
		System.out.println("Colours available in set are:");
		for (String c : uniqueColours){
			System.out.println(c);
		}	
	}
}