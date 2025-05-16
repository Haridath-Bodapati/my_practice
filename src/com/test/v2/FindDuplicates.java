package com.test.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("abc");
		strings.add(null);
		strings.add("abc");
		strings.add("xyz");
		strings.add("def");
		strings.add(null);
		strings.add("def");
	
		List<String> duplicateStrings = strings.stream().collect(Collectors.groupingBy(e -> (null == e ? "null": e), Collectors.counting()))
														.entrySet().stream().filter(e -> e.getValue() > 1)
														.map(Map.Entry :: getKey)
														.collect(Collectors.toList());
		
		System.out.println(duplicateStrings);
	}

}
