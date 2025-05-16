package com.java8;

import java.util.Objects;

public class Employee {

	private String name;
	private int salary;
	private String dept;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Employee(String name, int salary, String dept) {
		super();
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}
	
	
	public int hashCode() {
		
		int result = 1;
		int prime = 31;
		
		result = result * prime + salary;
		result = result * prime + (null == name ? 0 : name.hashCode());
		result = result * prime + (null == dept ? 0 : dept.hashCode());
		return result;
	}
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(null == obj || getClass() != obj.getClass())
			return false;
		Employee emp = (Employee) obj;
		return salary == emp.salary
				&& Objects.equals(name, emp.name)
				&& Objects.equals(dept, emp.dept);
	}
	
	/*@Override
	public int hashCode() {
		int result = 1;
		int prime = 31;
		
		result = result + prime * (name == null ? 1 : name.hashCode());
		result = result + prime * salary;
		result = result + prime * (dept == null ? 1 : dept.hashCode());
		
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true; // Same reference, objects are equal
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false; // Null or not the same class
	    }

	    Employee emp = (Employee) obj;

	    // Null-safe comparison for fields
	    return salary == emp.salary &&
	           Objects.equals(name, emp.name) &&
	           Objects.equals(dept, emp.dept);
	}*/
	
	/*@Override
	public boolean equals(Object obj) {
		
		if(this == obj)
			return true;
		
		if(obj == null || getClass() != obj.getClass())
			return false;
		
		Employee emp = (Employee) obj;
		
		return salary == emp.salary &&
				Objects.equals(name, emp.name) &&
				Objects.equals(dept, emp.dept);
		
		
		//if(!(obj instanceof Employee)) This will break for the child classes
			//return false;
		
		
	}*/
	
	/*@Override
	public int hashCode( ) {
		
		int result = 1;
		int prime = 31;
		
		result = result + prime * salary;
		result = result + prime * (dept == null ? 1 : dept.hashCode());
		result = result + prime * (name == null ? 1 : name.hashCode());
		
		return result;
		
		
		
	}*/

	
	
}
