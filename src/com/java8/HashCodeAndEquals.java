package com.java8;

public class HashCodeAndEquals {
	Employee emp1 = new Employee("hari", 1, "it");
	Employee emp2 = new Employee("hari", 1, "it");

	public static void main(String[] args) {
		
		HashCodeAndEquals codeAndEquals = new HashCodeAndEquals();
		
		System.out.println("Equals output is "+codeAndEquals.emp1.equals(codeAndEquals.emp2));
		System.out.println("Hashcode output emp1 is "+codeAndEquals.emp1.hashCode());

		System.out.println("Hashcode output emp2 is "+codeAndEquals.emp2.hashCode());

	}
	


}
