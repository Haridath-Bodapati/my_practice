package com.test.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.test.Employee;

public class EmployeeNameComparator {

	public static void main(String[] args) {

		Comparator<Employee> nameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };
        
        
        // Creating a TreeMap with the custom Comparator
       // TreeMap<Employee, String> employeeMap = new TreeMap<>(nameComparator);
        TreeMap<Employee, String> employeeMap = new TreeMap<>(Comparator.comparing(Employee::getName));

        // Adding entries to the TreeMap
        employeeMap.put(new Employee(1, "John", 50000, null, null, 0, 0), "HR");
        employeeMap.put(new Employee(3, "Alice", 70000, null, null, 0, 0), "Engineering");
        employeeMap.put(new Employee(2, "Bob", 60000, null, null, 0, 0), "Marketing");

        // Printing the TreeMap (automatically sorted by Employee name)
        for (Employee emp : employeeMap.keySet()) {
            System.out.println(emp + " -> Department: " + employeeMap.get(emp));
        }
        
        /**
         * TreeSet and TreeMap do not allow null keys: 
         * This restriction leads to a NullPointerException when you attempt to add a null key.
         * The error happens at runtime, as the TreeSet or TreeMap will try to compare the null 
         * key with other keys in the set or map. Since null cannot be compared, a NullPointerException is thrown.
         */
        
        
        /**
         * TreeMap don't allows null keys.
         */
        TreeMap<String, String> map = new TreeMap<>();
        //map.put(null, "Value");  // Throws NullPointerException
        
        /**
         * TreeMap don't allow null values.
         */
        map = new TreeMap<>();
        map.put("Key1", null);  // Null value is allowed
        map.put("Key2", "Value2");
        System.out.println(map);  // Output: {Key1=null, Key2=Value2}
        
        /**
         * TreeSet and EnumSet don't allows null values.
         */
        TreeSet<String> treeSet = new TreeSet<>();
        // This will throw a NullPointerException
        //treeSet.add(null);
        
        /**
         * HashSet allows null values.
         */
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(null);  // This is allowed
        hashSet.add(null);  // Still only one null in the set
        System.out.println(hashSet);  // Output: [null]
        
        /**
         * LinkedHashSet allows null values.
         */
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);  // This is allowed
        System.out.println(linkedHashSet);  // Output: [null]
        
        /**
         * ************************* Sorting *********************
         * 
         */
        List<Integer> alist = new ArrayList<>();
        alist.add(5);
        alist.add(2);
        alist.add(9);

        // Sorting the list in reverse order using a custom Comparator
        Collections.sort(alist, Comparator.reverseOrder());
        System.out.println(alist);  // Output: [9, 5, 2]
        
        
        List<String> strList = new ArrayList<>();
        strList.add("Banana");
        strList.add("Apple");
        strList.add("Orange");

        // Sorting the list in natural order
        strList.sort(String::compareTo);  // Equivalent to Collections.sort(list)

        System.out.println(strList);  // Output: [Apple, Banana, Orange]
        
        
        /**
         * ************************* Sorting list Java8 *********************
         * 
         */
        
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30));
        employees.add(new Employee("Alice", 25));
        employees.add(new Employee("Bob", 35));

        // Sorting by age using List.sort() and a Comparator
        employees.sort(Comparator.comparingInt(Employee::getAge));

        System.out.println(employees);  // Output: sorted by age
        
        /**
         * ************************* Sorting Set *********************
         * Set: No direct sort method, but you can: Convert it to a List and sort it.
         * Use a TreeSet for natural or custom ordering.
         * 
         * Map: No direct sort method, but you can:
         * Sort by keys using a TreeMap.
         * Sort by values by converting entrySet() to a List and sorting it with a Comparator.
         * 
         */
        Set<String> set = new HashSet<>();
        set.add("Banana");
        set.add("Apple");
        set.add("Orange");

        // Convert Set to List for sorting
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);  // Sort the list

        System.out.println(list);  // Output: [Apple, Banana, Orange]
        
        Set<String> set1 = new TreeSet<>(set);  // Automatically sorted
        set1.add("Banana1");
        set1.add("Apple1");
        set1.add("Orange1");

        System.out.println("************************* Sorting Set * " + set1);  // Output: [Apple, Banana, Orange]
        
        /**
         * ************************* Sorting Map *********************
         * 
         */
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Banana", 3);
        map1.put("Apple", 5);
        map1.put("Orange", 2);

        // Sorting by keys using TreeMap
        Map<String, Integer> sortedMap = new TreeMap<>(map1);

        System.out.println(sortedMap);  // Output: {Apple=5, Banana=3, Orange=2}
        
        /**
         * ************************* Sorting Map by Values *********************
         * 
         */
        
     // Convert Map entries to List
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map1.entrySet());

        // Sort the list by values
        entryList.sort(Map.Entry.comparingByValue());

        // Create a sorted LinkedHashMap to preserve order
        Map<String, Integer> sortedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println(sortedHashMap);  // Output: {Orange=2, Banana=3, Apple=5}
        
        /**
         * ************************* Sorting Map by Tree map *********************
         * 
         */
        
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Banana", 3);
        treeMap.put("Apple", 5);
        treeMap.put("Orange", 2);

        System.out.println(treeMap);  // Output: {Apple=5, Banana=3, Orange=2}
	}

}
