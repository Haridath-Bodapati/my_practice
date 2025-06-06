package com.java8;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Employee {
    public static void main(String[] args) {
        //i/p list of employee
        List<Employee1> empList = new ArrayList<>();
        empList.add(new Employee1(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee1(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee1(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee1(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee1(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee1(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee1(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee1(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee1(9, "stv", 25, 160, "M", "IT", "Blore", 2010));


        // Group employees by city
        Map<String, List<Employee1>> empByCity;
        empByCity = empList.stream().collect(Collectors.groupingBy(Employee1::getCity));
        System.out.println("Employees grouped by city :: \n" + empByCity);

        // Group Employees by age
        Map<Integer, List<Employee1>> empByAge = empList.stream().collect(Collectors.groupingBy(Employee1::getAge));
        System.out.println("Employees grouped by age :: \n" + empByAge);


        //Find  the count of male and female employees present in the organization
        Map<String, Long> noOfMaleAndFemaleEmployees =
                empList.stream()
                        .collect(Collectors.groupingBy
                                (Employee1::getGender, Collectors.counting()));
        System.out.println("Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);


        //Print the names of all departments in the organization
        System.out.println("Names of all departments in the organization ");
        empList.stream()
                .map(Employee1::getDeptName)
                .distinct()
                .forEach(System.out::println);

        // print employee details whose age is greater than 28
        System.out.println("Employee details whose age is greater than 28");
        empList.stream().filter(e -> e.getAge() > 28).collect(Collectors.toList()).forEach(System.out::println);

        // find maximum age of employee
        OptionalInt max = empList.stream().
                mapToInt(Employee1::getAge).max();

        if (max.isPresent()) System.out.println("Maximum age of Employee: " + max.getAsInt());

        //Print Average age of Male and Female Employees
        Map<String, Double> avgAge = empList.stream()
                .collect(Collectors.groupingBy
                        (Employee1::getGender,
                                Collectors.averagingInt
                                        (Employee1::getAge)));
        System.out.println("Average age of Male and Female Employees:: " + avgAge);


        //Print the number of employees in each department.
        Map<String, Long> countByDept = empList.stream()
                .collect(Collectors.groupingBy
                        (Employee1::getDeptName,
                                Collectors.counting()));
        System.out.println("No of employees in each department");
        for (Map.Entry<String, Long> entry : countByDept.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        //Find oldest employee
        Optional<Employee1> oldestEmp = empList.stream()
                .max(Comparator.comparingInt(Employee1::getAge));
        Employee1 oldestEmployee = oldestEmp.get();
        System.out.println("Oldest employee details:: \n" + oldestEmployee);

        // Find youngest  female employee
        Optional<Employee1> youngestEmp = empList.stream().filter(e -> e.getGender() == "F")
                .min(Comparator.comparingInt(Employee1::getAge));
        Employee1 youngestEmployee = youngestEmp.get();
        System.out.println("Youngest Female employee details:: \n" + youngestEmployee);

        // Find employees whose age is greater than 30 and less than 30
        System.out.println("Employees whose age is greater than 25 and less than 25");
        Map<Boolean, List<Employee1>> partitionEmployeesByAge =
                empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        Set<Map.Entry<Boolean, List<Employee1>>> empSet = partitionEmployeesByAge.entrySet();

        for (Map.Entry<Boolean, List<Employee1>> entry : empSet) {
            if (Boolean.TRUE.equals(entry.getKey())) {
                System.out.println("Employees greater than 30 years ::" + entry.getValue());
            } else {
                System.out.println("Employees less than 30 years ::" + entry.getValue());
            }
        }

        //Find the department name which has the highest number of employees
        Map.Entry<String, Long> maxNoOfEmployeesInDept = empList.stream().collect(Collectors.groupingBy(Employee1::getDeptName, Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept.getKey());
        
        List<String> listStr = new ArrayList<>();
		listStr.add("Test");
		listStr.add("Test");
		listStr.add("Test1");
		listStr.add("Test2");
		listStr.add("Test3");
		listStr.add("Test3");
		listStr.add(null);
		listStr.add(null);
		
		List<String> duplicateStrings = listStr.stream().collect(Collectors.groupingBy(e-> null == e ? "null" : e,Collectors.counting()))
														.entrySet().stream().filter(e -> e.getValue() > 1)
														.map(e -> "null".equals(e) ? null : e.getKey())
														.sorted(Comparator.reverseOrder())
														.sorted(Comparator.nullsFirst(Comparator.comparing(Function.identity())))
														.collect(Collectors.toList());

		
		System.out.println(duplicateStrings);
		
		//To find duplicated words in a string
		String str = "This is the word to test the count";
		String[] strArr = str.split("\\s+");
		List<String> duplicatedWods = Arrays.asList(strArr).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
		
		System.out.println("duplicatedWods "+duplicatedWods);
		
		
		//Max repeated character
		String string = "THISIS";
		Optional<Entry<Character, Long>> C = string.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
							.max(Map.Entry.comparingByValue());
		
		if(C.isPresent()) {
			System.out.println(" ++++++++++++++ Max time preseneted character is "+ C.get().getKey());
		}
		
		
		//String string = "THISIS";

        // Step 1: Compute frequency of each character
        Map<Character, Long> frequencyMap = string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Step 2: Find the maximum frequency
        long maxCount = frequencyMap.values().stream()
                .max(Long::compare)
                .orElse(0L);
        
        Map<Integer, Long> map = HashMap.newHashMap(1);
        map.put(1, 1l);
        map.put(2, 2l);
        System.out.println("map " + map);

        // Step 3: Find all characters with the maximum frequency
        List<Character> maxFrequencyChars = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Characters with maximum frequency: " + maxFrequencyChars);
		


        // Find if there any employees from HR Department
        // can use anyMatch also
        Optional<Employee1> emp = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR"))
                .findAny();
        emp.ifPresent(employee1 -> System.out.println("Found employees from HR department " + employee1));


        //Find the department names that these employees work for, where the number of employees in the department is over 3
        System.out.println("Department names where the number of employees in the department is over 3 :: ");
        empList.stream().collect(Collectors.groupingBy(Employee1::getDeptName, Collectors.counting())).
                entrySet().stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);

        //Find distinct department names that employees work for.
        System.out.println("Distinct department names that employees work for:: ");
        empList.stream().map(Employee1::getDeptName).distinct().forEach(System.out::println);


        //Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
        empList.stream()
                .filter(e -> e.getCity().equalsIgnoreCase("Blore"))
                .sorted(Comparator.comparing(Employee1::getName))
                .forEach(e -> System.out.println("Employees staying in Blore:: " + e.getName()));

        // No of employees in the organisation
        System.out.println("No of employees in the organisation :: " + empList.stream().count());

        //Find employee count in every department
        Map<String, Long> employeeCountInDepartmentMap = empList
                .stream()
                .collect(Collectors.groupingBy(Employee1::getDeptName, Collectors.counting()));

        System.out.print("Employee department and its count :- \n"
                + employeeCountInDepartmentMap);

        // Find the department which has the highest number of employees.
        Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = employeeCountInDepartmentMap.entrySet().stream().max(Map.Entry.comparingByValue());
        if (deptNameWithHighestEmp.isPresent()) {
            System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get());
        }


        // Sorting a Stream by age and name fields
        System.out.println("Sorting based on name and age:: ");
        Comparator<Employee1> comparator1 = Comparator.comparing(Employee1::getName);
        Comparator<Employee1> comparator2 = Comparator.comparingInt(Employee1::getAge);

        empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

        // Highest experienced employees in the organization
        Optional<Employee1> seniorEmp = empList.stream()
                .sorted(Comparator
                        .comparingInt(Employee1::getYearOfJoining)).findFirst();
        System.out.println("Senior Employee Details :" + seniorEmp.get());

        //Print average and total salary of the organization.
        DoubleSummaryStatistics empSalary = empList.stream()
                .collect(Collectors
                        .summarizingDouble(Employee1::getSalary));

        System.out.println("Average Salary in the organisation = " + empSalary.getAverage());
        System.out.println("Total Salary in the organisation  = " + empSalary.getSum());

        //Print Average salary of each department
        System.out.println("Print Average salary of each department");
        Map<String, Double> avgSalary = empList.stream()
                .collect(Collectors.groupingBy
                        (Employee1::getDeptName,
                                Collectors.averagingDouble(Employee1::getSalary)));
        Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
        for (Map.Entry<String, Double> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        //Find Highest salary in the organisation
        Optional<Employee1> empHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee1::getSalary).reversed()).findFirst();

        System.out.println("Highest Salary in the organisation : " + empHighest.get().getSalary());

        //Find Second Highest salary in the organisation
        Optional<Employee1> emp2 = empList.stream()
                .sorted(Comparator.comparingDouble(Employee1::getSalary)
                        .reversed())
                .skip(2)
                .findFirst();

        System.out.println("Second Highest Salary in the organisation : " + emp2.get().getSalary());


        Optional<Employee1> emp3 = empList.stream()
                .sorted(Comparator.comparingDouble(Employee1::getSalary)
                        .reversed())
                .skip(3)
                .findFirst();

        System.out.println("Third Highest Salary  in the organisation : " + emp3.get().getSalary());

        //Nth Highest salary


        // Find highest paid salary in the organisation based on gender
        Map<String, Optional<Employee1>> highestPaidMFEmployee = empList.stream()
                .collect(Collectors.groupingBy(Employee1::getGender, Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));

        System.out.println("Highest paid male and female employee : " + highestPaidMFEmployee);

        // Find lowest paid salary in the organisation based in the organisation
        Map<String, Optional<Employee1>> lowestPaidMFEmployee = empList.stream()
                .collect(Collectors.groupingBy(Employee1::getGender, Collectors.minBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));

        System.out.println("Lowest paid male and female employee : " + lowestPaidMFEmployee);

        // sort the employees salary in the organisation in ascending order
        System.out.println("Sorting the organisation's employee salary in ascending order ");
        empList.stream().sorted(Comparator.comparingLong(Employee1::getSalary)).toList().forEach(System.out::println);

        // sort the employees salary in the organisation in descending order
        System.out.println("Sorting the organisation's employee salary in descending order ");
        empList.stream().sorted(Comparator.comparingLong(Employee1::getSalary).reversed()).toList().forEach(System.out::println);

        // sort the employees salary in each department in ascending order
        System.out.println("Sorting the department wise employee salary in ascending order:: ");
        Map<String, Stream<Employee1>> sortedEmployeeAsc = empList.stream().collect(Collectors.groupingBy(Employee1::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparingDouble(Employee1::getSalary)))));

        sortedEmployeeAsc.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });

        // sort the employees salary in each department in descending order
        System.out.println("Sorting the department wise employee salary in descending order ");
        Map<String, Stream<Employee1>> sortedEmployeeDesc = empList.stream().collect(Collectors.groupingBy(Employee1::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparingDouble(Employee1::getSalary).reversed()))));

        sortedEmployeeDesc.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });

        // Highest salary based on department
        System.out.println("Highest salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee1::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                list4 -> list4.stream().max(Comparator.comparingDouble(Employee1::getSalary))))));

        //Print list of employee's second highest record based on department
        System.out.println("Highest second salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee1::getDeptName,
                Collectors.collectingAndThen(Collectors.toList(),
                        list3 -> list3.stream().
                                sorted(Comparator.comparingDouble(Employee1::getSalary).reversed()).skip(1).findFirst()))));
    }
}

class Employee1 {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee1(int id, String name, int age, long salary, String gender, String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "Employee1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
}