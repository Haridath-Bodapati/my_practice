package com.java8;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateFInder {
	
	public static void main(String args[]) {

		List<String> lst = new ArrayList<>();
		lst.add("java");
		lst.add("aws");
		lst.add("java");
		lst.add("aws");
		lst.add("kafka");
		lst.add(null);
		lst.add(null);
		
		
		List<String> dupStrings = lst.stream().collect(Collectors.groupingBy(e -> null == e ? "null": e,Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1)
				.map(e -> "null".equals(e) ? null : e.getKey())
				.sorted(Comparator.nullsFirst(Comparator.reverseOrder()))
				.collect(Collectors.toList());
		
		Map<Employee, Employee> treeMap = new TreeMap<>(Comparator.comparing(Employee :: getName));
		String str = "TTEESSSXXX";
		char chars[] = str.toCharArray();
		SecureRandom sr = new SecureRandom();

		for(int startIndex = 0, endIndex = str.length() - 1; startIndex < endIndex / 2; startIndex++, endIndex--) {
			char temp = chars[startIndex];
			chars[startIndex] = chars[endIndex];
			chars[endIndex] = temp;
		}
		
		String reversed = new String(chars);
		System.out.println("Reversed string is "+ reversed);
		sr.nextInt(str.length());
												
												
		
		System.out.println("dupStrings is "+dupStrings);
		
		
		
		
		
		
		
		

		/*List<String> dupStrings = lst.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(e -> e.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
		System.out.println(dupStrings);

		lst.stream().collect(Collectors.groupingBy(e -> e == null ? "null" : e, Collectors.counting())).entrySet()
				.stream().filter(e -> e.getValue() > 1).map(e -> "null".equals(e.getKey()) ? null : e.getKey())
				.collect(Collectors.toList());

		List<String> duplicates = lst.stream()
				.collect(Collectors.groupingBy(item -> item == null ? "null" : item, Collectors.counting())).entrySet()
				.stream().filter(e -> e.getValue() > 1).map(Map.Entry::getKey)
				.collect(Collectors.toList());

		System.out.println(duplicates);*/
	}

}
