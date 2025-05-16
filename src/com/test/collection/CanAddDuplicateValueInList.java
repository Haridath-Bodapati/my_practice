package com.test.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CanAddDuplicateValueInList {	
	
	public static void main(String[] args) {
		
		List<String> uniqueColours = new ArrayList();
		
		uniqueColours.add("Red");
		uniqueColours.add("Green");
		uniqueColours.add("Blue");
		System.out.println("Size of list is :"+ uniqueColours.size());
		uniqueColours.add("Blue"); /*Adding duplicate value here, 
		will add duplicate value */
		System.out.println("Size of list is :"+ uniqueColours.size());
		boolean returnVal = uniqueColours.add(null);
		System.out.println("returnVal :"+ returnVal);
		System.out.println("Size of list is :"+ uniqueColours.size());
		boolean returnVal1 = uniqueColours.add(null);
		System.out.println("Size of list is :"+ uniqueColours.size());
		
		System.out.println("Colours available in List are:");
		for (String c : uniqueColours){
			
			System.out.println(c);
		}	
	}
}