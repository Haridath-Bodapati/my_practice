//Jesus
package com.test.jpmc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.test.Employee;

public class JPTest3 {
	public static void main(String[] args) {
		
		Map<Employee, String> testEmployees = new HashMap<>();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		testEmployees.put(e1, null);
		testEmployees.put(e2, null);
		
		System.out.println("Employees size is "+testEmployees.size());
		
		/**
		 * Employee - ename, location
		 * Find How many employees are there in location and count
		 */
		
		List<Employee> employees = new ArrayList<>();
		
		Map<String, Long> lie = employees.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		
		String palindromeStr  = "545";
		StringBuffer sb = new StringBuffer(palindromeStr);
		
		char temp = 'c';
		int startIndex = 0, endIndex = palindromeStr.length() - 1;
		while(startIndex < endIndex) {
			temp = palindromeStr.charAt(endIndex);
			sb.setCharAt(startIndex, palindromeStr.charAt(endIndex));
			sb.setCharAt(endIndex, temp);
			
			startIndex++;
			endIndex--;
		}
		
		for(int i=palindromeStr.length()-1; i<palindromeStr.length(); i--){
			sb.append(palindromeStr.charAt(i));
		}
		
		if(sb.equals(palindromeStr)) {
			//return true;
		}
		
		/*HttpSecurity
		httpSecurity().allowedOrigins().has
		@Qualifier("")
		
		int palindromeNum = Integer.parseInt(palindromeStr);
		//while()

			id, name, salary
			
			select e1.salary from emp e1 where 1 = (select count(Distinct(e1.salary)) from employee2 where emplyee2.salary > employee1.salary)
			
			
			New features in angular 18, routing in angular, can we have multiple router-routlet tags in angular
			
			func(xx ...)
			var total: number;
			for(a=0; a>xx.length; a++) {
				
				totat = total + xx[a];
			}*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
