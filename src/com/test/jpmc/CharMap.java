package com.test.jpmc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharMap {

	public static void main(String args[]) {
		String input = "aaabbcddde";
		// output = a3b2c1d3e1

		Map<Character, Long> charCountMap = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println("charCountMap is "+ charCountMap);
		
		HashMap<Character, Integer> charCountTraditionalMap = new HashMap<>();
		
		for(int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			charCountTraditionalMap.put(c, charCountTraditionalMap.getOrDefault(c, charCountTraditionalMap.get(c) + 1));
			
			if(charCountTraditionalMap.get(c) == null) {
				charCountTraditionalMap.put(c, 1);
			} else {
				charCountTraditionalMap.put(c, charCountTraditionalMap.get(c) + 1);
			}
			 
			//input.charAt(i);
		}
		
		System.out.println("charCountTraditionalMap is "+charCountTraditionalMap);
		
		
		for(int i = 0; i < input.length(); i++) {
			if(i+1 < input.length()) {
				if(input.charAt(i) == input.charAt(i+1)) {
					
				}
			}
		}

	}
	
	/*class Stack<T> {
		LinkedList<T> stackArr = new LinkedList<>();
		T top;
		public void push(T t) {	
			stackArr.add(t);
			//return stackArr;
		}
		
		public T pop(T t) {
			
		}
	}*/
}
