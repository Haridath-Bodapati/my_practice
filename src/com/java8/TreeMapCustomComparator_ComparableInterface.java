package com.java8;


import java.util.TreeMap;

//Employeee class implementing Comparable
class Employeee implements Comparable<Employeee> {
 private int id;
 private String name;
 private double salary;
 private String dept;

 public Employeee(int id, String name, double salary) {
     this.id = id;
     this.name = name;
     this.salary = salary;
 }

 /**
 * @return the dept
 */
public String getDept() {
	return dept;
}

/**
 * @param dept the dept to set
 */
public void setDept(String dept) {
	this.dept = dept;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @param salary the salary to set
 */
public void setSalary(double salary) {
	this.salary = salary;
}

// Getters
 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public double getSalary() {
     return salary;
 }

 // Overriding compareTo to define natural ordering by id
 @Override
 public int compareTo(Employeee other) {
     return Integer.compare(this.id, other.id);
 }

 // Overriding toString for easy printing
 @Override
 public String toString() {
     return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + '}';
 }

 // Overriding equals and hashCode (important when using TreeMap or other maps)
 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     Employeee employee = (Employeee) o;
     return id == employee.id;
 }

 @Override
 public int hashCode() {
     return Integer.hashCode(id);
 }
}

public class TreeMapCustomComparator_ComparableInterface {
 public static void main(String[] args) {
     // Creating a TreeMap with Employee as the key and String as the value
     TreeMap<Employeee, String> employeeMap = new TreeMap<>();

     // Adding entries to the TreeMap
     employeeMap.put(new Employeee(1, "John", 50000), "HR");
     employeeMap.put(new Employeee(3, "Alice", 70000), "Engineering");
     employeeMap.put(new Employeee(2, "Bob", 60000), "Marketing");

     // Printing the TreeMap (automatically sorted by Employee id)
     for (Employeee emp : employeeMap.keySet()) {
         System.out.println(emp + " -> Department: " + employeeMap.get(emp));
     }
 }
}

