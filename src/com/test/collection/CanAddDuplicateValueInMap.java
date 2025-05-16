package com.test.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CanAddDuplicateValueInMap {
	
	public static void main(String[] args) {
		
		HashMap<String, String> options = new HashMap<String, String>();  
		String returnVal = options.put("name", "value");
		System.out.println("returnVal :"+ returnVal);
		options.put(null, null);  
		options.put(" ", " "); 
		returnVal = options.put("name", " ");
		System.out.println("returnVal :"+ returnVal);
		System.out.println("Size of list is :"+ options.size());
		//options.put();
 
	}
}