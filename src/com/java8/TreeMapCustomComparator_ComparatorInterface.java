package com.java8;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapCustomComparator_ComparatorInterface {
    public static void main(String[] args) {
        // Creating a custom Comparator to sort by Employeee's name
        Comparator<Employeee> nameComparator1 = new Comparator<Employeee>() {
            @Override
            public int compare(Employeee e1, Employeee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        };
        
        Comparator<Employeee> nameComparator2 = (e1, e2) -> e1.getName().compareTo(e2.getName());
        Comparator<Employeee> nameComparator = Comparator.comparing(Employeee::getName);

        
        /** Either we need to implement the Key with Comparable interface or use Custom Comparator while intializing treemap
        otherwise its throws ClassCastException.**/
        
        // Creating a TreeMap with the custom Comparator
        TreeMap<Employeee, String> employeeMap = new TreeMap<>(nameComparator);
        
        //This will throw exception because if we don't implement comparable interface for Employee class, now its implemented
        // So, it is not throwing exception.
        //TreeMap<Employeee, String> employeeMap = new TreeMap<>();

        // Adding entries to the TreeMap
        employeeMap.put(new Employeee(1, "John", 50000), "HR");
        employeeMap.put(new Employeee(3, "Alice", 70000), "Engineering");
        employeeMap.put(new Employeee(2, "Bob", 60000), "Marketing");

        // Printing the TreeMap (automatically sorted by Employeee name)
        for (Employeee emp : employeeMap.keySet()) {
            System.out.println(emp + " -> Department: " + employeeMap.get(emp));
        }
    }
}
