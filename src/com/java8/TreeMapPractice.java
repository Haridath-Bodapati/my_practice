package com.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapPractice {

	public static void main(String[] args) {
		
		Map<Integer, String> testHashMap = new HashMap<>();
		//testHashMap.put(null, "nullkey");
		//testHashMap.put(null, "nullkey1");
		testHashMap.put(10, "Ten");
		testHashMap.put(1, "One");
		testHashMap.put(7, "Seven");
		testHashMap.put(-1, "Seven");
		
		Map<Integer, String> testTreeMap = new TreeMap<>();
		//testTreeMap.put(null, "Null");
		testTreeMap.put(10, "Ten");
		testTreeMap.put(1, "One");
		testTreeMap.put(7, "Seven");
		
		System.out.println("Tree Map value is ******** "+ testTreeMap);
		
		
		testTreeMap = new TreeMap<>(testHashMap);
		testTreeMap.put(10, "Ten");
		testTreeMap.put(1, "One");
		testTreeMap.put(7, "Seven");
		
		//testTreeMap.put(null, "Null");
		testTreeMap.put(5, null);
		testTreeMap.put(6, null);
		
		System.out.println("Tree Map with Hashmap intializiation is ******** "+ testTreeMap);
		
		testTreeMap = new TreeMap<>(Collections.reverseOrder());
		System.out.println("Tree Map with reverseOrder ******** "+ testTreeMap);
		
		TreeMap<Employeee, Employeee> empTreeMap = new TreeMap<>(Comparator.comparing(Employeee::getDept));
		
		
		Comparator<Employeee> empCompartor = Comparator.comparing(Employeee::getSalary);
		//empTreeMap.put(new Employee(empCompartor), null);
		System.out.println("Employee Tree sorting based on department ******** "+ empTreeMap);
	}

}
