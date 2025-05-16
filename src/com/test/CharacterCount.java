package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCount {

	public static void main(String[] args) {
		//int[] numbers = new int[] {1,3,3,4,4,4};
		int count = CharacterCount.countDuplicate(List.of(3,3,1,4,4,4));
		System.out.println("The duplicate count is "+count);
	}

	public static int countDuplicate(List<Integer> numbers) {
		int count = 0;
		/*
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<numbers.size(); i++) {
			if(!map.containsKey(numbers.get(i))) {
				map.put(numbers.get(i), 1);
			} else {
				map.put(numbers.get(i), map.get(numbers.get(i))+1);
			}
		}
		
		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			if(entry.getValue() > 1) {
				count++;
			}
		}
		
		System.out.println(getDuplicateChars("aaabbcddeef"));
		
		*/
		count = (int)numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey).count();
		return count;
	}
	
	public static List<Character> getDuplicateChars(String s){
		
		String someString = "elephant";
		long count = someString.chars().filter(ch -> ch == 'e').count();
		System.out.println("The count of e is " + count);
		
		List<Character> dupChars = someString.chars().mapToObj(c -> (char) c)
						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
						.entrySet().stream().filter( e -> e.getValue() > 1)
						.map(Map.Entry :: getKey)
						.collect(Collectors.toList());
						
		
		/*Map<Character, Long> charMap = someString.chars().mapToObj(c -> (char) c)
														.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("char Map is" + charMap);
		
		
		List<Entry<Character, Long>> list = charMap.entrySet().stream().filter(e->e.getValue() > 1).collect(Collectors.toList());
		System.out.println("Duplicate chars list is" + list);*/
		
		return dupChars;
	}
	
	
}
