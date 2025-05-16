package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicates {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("abc");
		strings.add("abc");
		strings.add("xyz");
		strings.add("def");
		strings.add("def");
		
		HashMap<String, Integer> countMap = new HashMap<>();
		HashMap<String, Integer> duplicateMap = new HashMap<>();
		
		for(int i = 0; i<strings.size(); i++) {
			if(!countMap.containsKey(strings.get(i))) {
				countMap.put(strings.get(i), 1);
			} else {
				countMap.put(strings.get(i), countMap.get(strings.get(i)) + 1);
				duplicateMap.put(strings.get(i), countMap.get(strings.get(i)));
			}
		}
		
		//System.out.println(countMap);
		//System.out.println(duplicateMap);//{abc=2, def=2}
		
		Map<String, Long> duplicateMapByStream =  strings.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println(duplicateMapByStream);
	}

}
