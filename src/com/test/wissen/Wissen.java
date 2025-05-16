//Jesus
package com.test.wissen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Wissen {
	public static void main(String[] args) {
		
		
		
		Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
	    
        Integer[] flattenedArray = null;
		try {
			flattenedArray = flattenArray(array);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(Arrays.toString(flattenedArray));
		
		
	}
	
	
	public static Integer[] flattenArray(Object[] inputArray) throws Exception {
	    if(inputArray == null)
	        return null;
	        
	        
	    //return Arrays.asList(inputArray).stream().flatMap(e -> e).toArray();
	    
	    return Arrays.stream(inputArray)
	            .flatMap(element -> {
	                if (element instanceof Object[]) {
	                    // Recursively flatten nested arrays
	                    try {
							return Arrays.stream(flattenArray((Object[]) element));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                } else if (element instanceof Integer) {
	                    return Arrays.stream(new Integer[]{(Integer) element});
	                } else {
	                    throw new IllegalArgumentException("Array contains non-integer elements");
	                }
					return null;
	            })
	            .toArray(Integer[]::new); // Collect results into an Integer[]
	}

}
