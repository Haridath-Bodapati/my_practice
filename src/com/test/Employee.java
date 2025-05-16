package com.test;

public class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
    public String toString() 
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", Department : "+department
                +", Year Of Joining : "+yearOfJoining
                +", Salary : "+salary;
    }
	
	@Override
	public int hashCode() {
		int result = 1;
		int prime = 31;
		
		result = result * prime + id;
		result = result * prime + ((department != null)? department.hashCode() : 0 );
									//((name == null) ? 0 : name.hashCode());
		result = result * prime + id;
		
		return result;
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Employee)) {
			return false;
		}
		
		Employee employeeObj = (Employee) obj;
		return ( this.age == employeeObj.age
				 && (this.department == null ? (employeeObj.getDepartment() != null ? false: true) : false));
	}
}