package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.TreeMap;

public class Java8Features {

	/*
	 * Jesus
	 * In Oracle Database, the TO_CHAR(datetime) function converts a datetime or interval value to a VARCHAR2 value in the format specified by the date format.
	   SELECT TO_CHAR(DATE '2035-09-26', 'DY, DD MONTH YYYY')
	   FROM DUAL;
	   
	   Result WED, 26 SEPTEMBER 2035
	   
	   The EXTRACT(datetime) function is used for extracting various datetime parts from a datetime value. This includes the day.
	   SELECT EXTRACT(YEAR FROM DATE '2027-10-03')
	   FROM DUAL;
	   
	   Result 2027
	   
	   Merge syntax
	   --------------
	    MERGE INTO people_target pt 
		USING people_source ps 
		ON    (pt.person_id = ps.person_id) 
		WHEN MATCHED THEN UPDATE 
		  SET pt.first_name = ps.first_name, 
		      pt.last_name = ps.last_name, 
		      pt.title = ps.title 
		WHEN NOT MATCHED THEN INSERT 
		  (pt.person_id, pt.first_name, pt.last_name, pt.title) 
		  VALUES (ps.person_id, ps.first_name, ps.last_name, ps.title);
		  
		
	 */
	static List<Employee> employees = new ArrayList<Employee>();
	public static void main(String[] args) {
		
		Employee emp1 = new Employee("hari1", 1000, "it1");
		Employee emp2 = new Employee("hari2", 2000, "it1");
		Employee emp3 = new Employee("hari3", 3000, "it");
		Employee emp4 = new Employee("hari4", 4000, "it");
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		
		
		Map<String, Employee> topEmployees = getTopSalariedEmpForDept(employees);

		for (Map.Entry<String, Employee> emp : topEmployees.entrySet()) {
			System.out.println("Top employee name " + emp.getKey());
			Employee empp = emp.getValue();

			System.out.println("Top employee name " + empp.getName());

		}
		
		int topSalay = getTopSalary(employees);
		System.out.println("Top salary is " + topSalay);
		
		int max = getMaxAndMinNumberInList();
		System.out.println("Max is " + max);
		
		uniqueString();
		getAllEmployeesNames(employees);
		getAllEmployeesNamesForDept(employees);
		getEmployeesNamesSalMoreThan1000(employees);
		getAllEmployeesByDept(employees);
		getAllEmployeesBySalary(employees);
		filterWithTwoChecks(employees);
		filterWithExceptionHandling(employees);
		filterWithExceptionHandling(employees);
		mapAndFilterExample();
		filterAndPeekExample(employees);
		maxLengthString();
		checkPrimeNumbers(10);
		
		
		
		int topNSalay = getTopNSalary(employees,2);
		System.out.println("Top Nth salary is " + topNSalay);
		
		peekMethodForDebugging();
	}
	
	private static void getAllEmployeesNames(List<Employee> employees) {
		List<String> allEmployeeNamesInList = employees.stream()
													.map(Employee::getName)
													.collect(Collectors.toList());
		System.out.println("All employee names in List "+allEmployeeNamesInList);
	}

	private static void getAllEmployeesNamesForDept(List<Employee> employees) {
		List<String> employeeNamesForParticularDept = employees.stream()
													.filter(e -> e.getDept().equalsIgnoreCase("it1"))
													.map(Employee::getName)
													.collect(Collectors.toList());
		System.out.println("Employees names for dept "+employeeNamesForParticularDept);
	}
	
	private static void getAllEmployeesByDept(List<Employee> employees) {
		Map<String, List<Employee>> groupByDeptEmployees = employees.stream()
																	.collect(Collectors.groupingBy(Employee::getDept));
		System.out.println("All employees for each dept "+groupByDeptEmployees);
		
		List<Employee> it1Employees = employees.stream().filter(e -> e.getDept().equals("it1")).collect(Collectors.toList());
		System.out.println("Employees by it1 "+it1Employees);
	}
	
	private static void getAllEmployeesBySalary(List<Employee> employees) {
		Map<Integer, List<Employee>> groupBySalEmployees = employees.stream()
																	.collect(Collectors.groupingBy(Employee::getSalary));
		System.out.println("All employees names by salary "+groupBySalEmployees);
	}

	private static void getEmployeesNamesSalMoreThan1000(List<Employee> employees) {
		List<String> empNames = employees.stream()
										 .filter(e -> e.getSalary() >= 1000)
										 .map(Employee::getName)
										 .collect(Collectors.toList());
		System.out.println("Filtered emp names whose sal greater than or equal to 1000" + empNames);
	}
	
	private static void filterAndPeekExample(List<Employee> employees) {

		List<Employee> filteredEmployeesAndChangingDeptId = employees.stream()
													.peek(e -> System.out.println("The size of employees list is "+ employees.size()))
													.filter(e -> e.getSalary() > 1000)
													//.map(e -> e.setDept("NewDept"))
													.peek(e -> System.out.println("The size of employees After filter is "+ employees.size()))
													.peek(e -> e.setDept("NewDept"))
													.collect(Collectors.toList());
				
		System.out.println(filteredEmployeesAndChangingDeptId);
	}
	
	
	private static void peekMethodForDebugging() {
		Stream.of("one", "two", "three", "four")
		  .filter(e -> e.length() > 3)
		  .peek(e -> System.out.println("Filtered value: " + e))
		  .peek(e -> e.toUpperCase())
		  //.map(String::toUpperCase)
		  .peek(e -> System.out.println("Mapped value: " + e))
		  .collect(Collectors.toList());
	}

	private static int getTopSalary(List<Employee> employees) {
		
		 return employees.stream().map(Employee::getSalary).max(Integer::compare).get();
	}
	
	private static int getTopNSalary(List<Employee> employees, int nthTop) {
		return employees.stream()
				 		//.filter(e -> e.getSalary() > 2000)
				 		.map(Employee::getSalary)
				 		.distinct()
				 		//.peek(e -> System.out.println("Peek : " + e))
				 		.sorted(Comparator.reverseOrder())
				 		//.peek(e -> System.out.println("After sorted Peek : " + e))
				 		.skip(nthTop - 1)
				 		//.peek(e -> System.out.println("After skip Peek : " + e))
				 		//.collect(Collectors.toList())
				 		//.get(0);
				 		//.orElseGet(null);
				 		//.skip(nthTop - 1)
				 		.peek(e -> System.out.println("Top Salary value: " + e))
				 		.findFirst()
				 		.orElseGet(null);
				 		/*Employee secondHighest = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .skip(1) // skip the first highest
                .findFirst()
                .orElse(null);*/
		//return secondHighest.getSalary();
		
		 
	}

	private static void filterWithTwoChecks(List<Employee> employees) {

		Predicate<Employee> saltestPredicate = e -> e.getSalary() > 100;
		Predicate<Employee> deptTestPredicate = m -> m.getDept().equals("it");
		Predicate<Employee> nameTestPredicate = mf -> mf.getName().equals("Charles");

		List<Employee> withTwoPredicates = employees.stream()
				.filter(e -> e.getSalary() > 100 && e.getName().startsWith("Charles")).collect(Collectors.toList());
		
		List<Employee> withAndOrPredicates = employees.stream().filter(nameTestPredicate.and(deptTestPredicate).or(saltestPredicate))
		.collect(Collectors.toList());

		/*List<Employee> withAndOrPredicates = employees.stream()
				.filter(saltestPredicate.and(nameTestPredicate).or(deptTestPredicate)).collect(Collectors.toList());*/
		
		System.out.println(" WithAndOrPredicates list: " + withAndOrPredicates);
		
	}

	private static String filterWithExceptionHandling(List<Employee> employees) {
		List<Employee> customersWithValidProfilePhoto = employees.stream().filter(c -> {
			try {
				return c.toString() != null;
			} catch (Exception e) {
				// handle exception
			}
			return false;
		}).collect(Collectors.toList());
		
		return null;
	}

	private static void mapAndFilterExample() {
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
		
		System.out.println("original list: " + numbers);
		List<Integer> even = numbers.stream()
									.map(s -> Integer.valueOf(s))
									.filter(number -> number % 2 == 0)
									.collect(Collectors.toList());
		
		compartorExample();
	}
	
	private static int getMaxAndMinNumberInList() {
		List<Integer> list = new ArrayList<>(Arrays.asList(4,12,19,10,90,30,60,17,90));
		int max = list.stream().max(Integer::compare).get();
		System.out.println("Max number is "+max);
		int min = list.stream().min(Integer::compare).get();
		System.out.println("Min number is "+min);
		return max;
	}

	private static void compartorExample() {
		Comparator<Employee> employeeNameComparator = Comparator.comparing(Employee::getName);
		Comparator<Employee> employee_Salary_Name_Comparator = Comparator.comparing(Employee::getSalary)
				.thenComparing(Employee::getName);
		Comparator<Employee> employeeNameComparator_nullFirst = Comparator.nullsFirst(employeeNameComparator);
		Comparator<Employee> employeeNameComparator_nullLast = Comparator.nullsLast(employeeNameComparator);
		
		Map<Employee, Integer> empMap = new HashMap<>();
		TreeMap<Employee, Integer> employeeTreeMap = new TreeMap<Employee, Integer>(Comparator.comparingInt(Employee::getSalary));
		TreeMap<Employee, Integer> employeeTreeMap1 = new TreeMap<>(empMap);
		Comparator<Employee> employeeNameComparator1
		= Comparator.comparing(
				Employee::getName);
		
		Comparator<Employee> employeeNameComparator2
	      = Comparator.comparing(
	        Employee::getName, (s1, s2) -> {
	            return s2.compareTo(s1);
	        });
		
		
		//All the employee names whose salary is 30 or more

		employees.stream().filter(e -> e.getSalary() >= 30).map(Employee::getName).collect(Collectors.toList());

		//Correct solution
		employees.stream().filter(e -> e.getSalary() >= 30).collect(Collectors.mapping(Employee::getName, Collectors.toList()));
	}
	
	private static Map<String, Employee> getTopSalariedEmpForDept(List<Employee> employees) {
		
		Map<String, Employee> topSalariedEmpMap = null;

		try {
			topSalariedEmpMap = employees.stream()
					.collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));
			Integer topSalary = employees.stream().map(Employee::getSalary).max(Integer::compare).get();
			Employee maxSalariedEmployee = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
			employees.stream().map(Employee::getSalary).max(Integer::compare).get();
			employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(0).findFirst().orElseGet(null);
			System.out.println("The topSalary is " + topSalary);
			System.out.println("topSalariedEmpMap "+topSalariedEmpMap);
			System.out.println("maxSalariedEmployee "+maxSalariedEmployee);
			
			// sort the employees salary in each department in ascending order
		    Map<String, Stream<Employee>> sortedEmployeeAsc = employees.stream().collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(Collectors.toList(),
		            list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)))));
		    System.out.println("Sorting the department wise employee salary in ascending order:: ");
		    System.out.println("sortedEmployeeAsc "+sortedEmployeeAsc);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return topSalariedEmpMap;
		
	}
	
	private static void sortMapToList() {
		Map<Integer, String> map = new HashMap<>();
        map.put(10, "apple");
        map.put(20, "orange");
        map.put(30, "banana");
        map.put(40, "watermelon");
        map.put(50, "dragonfruit");

        // split a map into 2 List
        List<Integer> resultSortedKey = new ArrayList<>();
        List<String> resultValues = map.entrySet().stream()
                //sort a Map by key and stored in resultSortedKey
                //.sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
                .peek(e -> resultSortedKey.add(e.getKey()))
                .map(x -> x.getValue())
                // filter banana and return it to resultValues
                .filter(x -> !"banana".equalsIgnoreCase(x))
                .collect(Collectors.toList());
        resultSortedKey.forEach(System.out::println);
        resultValues.forEach(System.out::println);
	}
	
	public static List<Character> getDuplicateChars(){
		
			String someString = "elephant";
			long count = someString.chars().filter(ch -> ch == 'e').count();
			System.out.println("The count of e is " + count);
			
			List<Character> dupChars = someString.chars().mapToObj(c -> (char) c)
							.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
							.entrySet().stream().filter( e -> e.getValue() > 1)
							.map(Map.Entry :: getKey)
							.collect(Collectors.toList());
			
			return dupChars;
	}
	
	public static Map<Character, Long> getDuplicateCharsIntoMap() {
		String someString = "elephant";
		Map<Character, Long> result = someString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(e -> e.getValue() > 1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		System.out.println("The duplicate characters map result is " + result);
		
		return result;
	}
	
	public static void maxLengthString() {
		String str = "Welcome to Epam Interview";
		//Find the longest word using streams
		
		String[] strArr = str.split(" ");
		
		HashMap<String, Integer> countMap = new HashMap<>();
		
		List<String> strList = Arrays.asList(strArr);
		String maxLengthStr = strList.stream().max(Comparator.comparing(String::length)).get();
		Integer compareString = employees.stream().max(Comparator.comparing(Employee::getSalary)).get().getSalary();
		System.out.println("compareString is " + compareString);
		
		/*for(String string : strList) {
			countMap.put(string, (int)string.chars().count());
		}*/
		
		//Entry maxStringEntry = countMap.entrySet().stream().max(Comparator.comparingInt(e->e.getValue())).get();
		//String maxLengthStr = (String) maxStringEntry.getKey();
		
		System.out.println("Max length string is " + maxLengthStr);
		System.out.println("Max length Salary is " + compareString);
	}
	
	public static void checkPrimeNumbers(int n) {
		List<Integer> primeNumbers = IntStream.rangeClosed(2, (int) Math.sqrt(n))
		.filter(x -> isPrime(x)).boxed()
		.collect((Collectors.toList()));
		
		System.out.println("primeNumbers is " + primeNumbers);
	}
	
	public static boolean isPrime(int number) {
        // Edge case for number 1
        if (number <= 1) {
            return false;
        }
        // Step 2 & 3: Generate a stream and check for divisors
        return !IntStream.rangeClosed(2, (int) Math.sqrt(number))
                         .anyMatch(i -> number % i == 0); // Step 4: Return true if no divisors found
    }
	
	public static List<String> uniqueString() {
		List<String> strings = Arrays.asList("AA", "BB", "AA", "CC");

		Map<String, Long> countMap = strings.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		List<String> notRepeatedStrings = countMap.entrySet().stream().filter(e -> e.getValue() == 1)
				.map(Map.Entry::getKey).collect(Collectors.toList());

		System.out.println("Not repeated strings: " + notRepeatedStrings);

		List<String> repeatedStrings = countMap.entrySet().stream().filter(e -> e.getValue() > 1)
																.map(Map.Entry :: getKey)
																.collect(Collectors.toList());
				
		System.out.println("Repeated strings: " + repeatedStrings);

		Optional<String> repeatedString = repeatedStrings.stream().findFirst();
		System.out.println("Repeated string: " + repeatedString);
		String repString = (repeatedString.isPresent() ? repeatedString.get() : null);
		return notRepeatedStrings;
	}
	
	
	public void iteratingOverHashMap() {
		HashMap<String, String> hm = new HashMap<>();
		hm.put("First", "1");
		hm.put("First", "2");
		hm.put("First", "3");

		// 1. Iterating HashMap through for loop
		for (Map.Entry<String, String> set : hm.entrySet()) {
			// Printing all elements of a Map
			System.out.println(set.getKey() + " = " + set.getValue());
		}

		// 3. Iterator
		Iterator<Entry<String, String>> new_Iterator = hm.entrySet().iterator();

		// Iterating every set of entry in the HashMap
		while (new_Iterator.hasNext()) {
			Map.Entry<String, String> new_Map = (Map.Entry<String, String>) new_Iterator.next();
			// Displaying HashMap
			System.out.println(new_Map.getKey() + " = " + new_Map.getValue());
		}

		// 4. Iterating through forEach and printing the elements
		hm.forEach((key, value) -> System.out.println(key + " = " + value));

		// 2. Iterating HashMap through forEach and Printing all. elements in a Map
		hm.forEach((key, value) -> System.out.println(key + " = " + value));

		// 4. Iterating every set of entry in the HashMap, and
		// printing all elements of it
		hm.entrySet().stream().forEach(input -> System.out.println(input.getKey() + " : " + input.getValue()));

		hm.entrySet().stream().filter(input -> input.getKey().contains("c")).collect(Collectors.toList());

	}

}
