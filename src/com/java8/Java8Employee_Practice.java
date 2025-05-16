package com.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Employee_Practice {
    public static void main(String[] args) {
    	
    	String a = "abc";
    	String b = "abc";
    	
        //i/p list of employee
        List<Employee2> empList = new ArrayList<>();
        empList.add(new Employee2(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee2(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee2(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee2(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee2(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee2(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee2(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee2(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee2(9, "stv", 25, 160, "M", "IT", "Blore", 2010));


        // Group employees by city
        Map<String, List<Employee2>> empByCityIntoDefaultList = empList.stream().collect(Collectors.groupingBy(Employee2::getCity));
        System.out.println("Employees grouped by city :: \n" + empByCityIntoDefaultList);
        
        Map<String, Set<Employee2>> empByCityIntoSet = empList.stream().collect(Collectors.groupingBy(Employee2::getCity, Collectors.toSet()));
        System.out.println("Employees grouped by city :: \n" + empByCityIntoSet);

        Map<Integer, List<String>> empNamesByAge = empList.stream().collect(Collectors.groupingBy(Employee2::getAge, Collectors.mapping(Employee2::getName, Collectors.toList())));
        System.out.println("Emp names by age group:: \n" + empNamesByAge);
        
        Map<Integer, Set<String>> empNamesByAgeIntoSet = empList.stream().collect(Collectors.groupingBy(Employee2::getAge, Collectors.mapping(Employee2::getName, Collectors.toSet())));
        System.out.println("Emp names by age group into set:: \n" + empNamesByAgeIntoSet);
        
        // Group Employees by age
        Map<Integer, List<Employee2>> empByAge;
        empByAge = empList.stream().collect(Collectors.groupingBy(Employee2::getAge));
        System.out.println("Employees grouped by age :: \n" + empByAge);


        //Find  the count of male and female employees present in the organization
        Map<String, Long> noOfMaleAndFemaleEmployees = empList.stream().collect(Collectors.groupingBy(Employee2::getGender, Collectors.counting()));
        System.out.println("Count of male and female employees present in the organization:: \n" + noOfMaleAndFemaleEmployees);
        
        Map<Integer, Set<Employee2>> groupedByAgeIntoSet = empList.stream().collect(Collectors.groupingBy(Employee2::getAge, Collectors.toSet()));
        System.out.println("Count of same age group:: \n" + groupedByAgeIntoSet);
        
        //Print the names of all departments in the organization
        System.out.println("Names of all departments in the organization ");
        empList.stream()
                .map(Employee2::getDeptName)
                .distinct()
                .forEach(System.out::println);

        // print employee details whose age is greater than 28
        System.out.println("Employee details whose age is greater than 28");
        empList.stream().filter(e -> e.getAge() > 28).collect(Collectors.toList()).forEach(System.out::println);

        // find maximum age of employee
        OptionalInt max = empList.stream().
                mapToInt(Employee2::getAge).max();

        if (max.isPresent()) System.out.println("Maximum age of Employee: " + max.getAsInt());

        //Print Average age of Male and Female Employees
        Map<String, Double> avgAge = empList.stream()
                .collect(Collectors.groupingBy
                        (Employee2::getGender,
                                Collectors.averagingInt
                                        (Employee2::getAge)));
        System.out.println("Average age of Male and Female Employees:: " + avgAge);


        //Print the number of employees in each department.
        Map<String, Long> countByDept = empList.stream()
                .collect(Collectors.groupingBy
                        (Employee2::getDeptName,
                                Collectors.counting()));
        System.out.println("No of employees in each department");
        for (Map.Entry<String, Long> entry : countByDept.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        //Find oldest employee
        Optional<Employee2> oldestEmp = empList.stream()
                .max(Comparator.comparingInt(Employee2::getAge));
        Employee2 oldestEmployee = oldestEmp.get();
        System.out.println("Oldest employee details:: \n" + oldestEmployee);

        // Find youngest  female employee
        Optional<Employee2> youngestEmp = empList.stream().filter(e -> e.getGender() == "F")
                .min(Comparator.comparingInt(Employee2::getAge));
        Employee2 youngestEmployee = youngestEmp.get();
        System.out.println("Youngest Female employee details:: \n" + youngestEmployee);

        // Find employees whose age is greater than 30 and less than 30
        System.out.println("Employees whose age is greater than 30 and less than 30");
        Map<Boolean, List<Employee2>> partitionEmployeesByAge =
                empList.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));

        Set<Map.Entry<Boolean, List<Employee2>>> empSet = partitionEmployeesByAge.entrySet();

        for (Map.Entry<Boolean, List<Employee2>> entry : empSet) {
            if (Boolean.TRUE.equals(entry.getKey())) {
                System.out.println("Employees greater than 30 years ::" + entry.getValue());
            } else {
                System.out.println("Employees less than 30 years ::" + entry.getValue());
            }
        }

        //Find the department name which has the highest number of employees
        Map.Entry<String, Long> maxNoOfEmployeesInDept = empList.stream().collect(Collectors.groupingBy(Employee2::getDeptName, Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept.getKey());


        // Find if there any employees from HR Department
        // can use anyMatch also
        Optional<Employee2> emp = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR"))
                .findAny();
        emp.ifPresent(employee1 -> System.out.println("Found employees from HR department " + employee1));


        //Find the department names that these employees work for, where the number of employees in the department is over 3
        System.out.println("Department names where the number of employees in the department is over 3 :: ");
        empList.stream().collect(Collectors.groupingBy(Employee2::getDeptName, Collectors.counting())).
                entrySet().stream().filter(entry -> entry.getValue() > 3).forEach(System.out::println);

        //Find distinct department names that employees work for.
        System.out.println("Distinct department names that employees work for:: ");
        empList.stream().map(Employee2::getDeptName).distinct().forEach(System.out::println);
        
      //Find employee names by city.
        Map<String, Set<String>> employeeNamesByCity
        = empList.stream().collect(
          Collectors.groupingBy(Employee2::getCity,
                     Collectors.mapping(Employee2::getName, Collectors.toSet())));
        System.out.println("********* Employees name by city:: "+ employeeNamesByCity);
        
		List<String> employeeNamesForITDept = empList.stream().filter(e -> e.getDeptName().equals("IT"))
						.collect(Collectors.mapping(Employee2::getName, Collectors.toList()));
		System.out.println("******* employeeNamesForITDept *******:: " + employeeNamesForITDept);


        //Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
        empList.stream()
                .filter(e -> e.getCity().equalsIgnoreCase("Blore"))
                .sorted(Comparator.comparing(Employee2::getName))
                .forEach(e -> System.out.println("Employees staying in Blore:: " + e.getName()));

        // No of employees in the organisation
        System.out.println("No of employees in the organisation :: " + empList.stream().count());

        //Find employee count in every department
        Map<String, Long> employeeCountInDepartmentMap = empList
                .stream()
                .collect(Collectors.groupingBy(Employee2::getDeptName, Collectors.counting()));

        System.out.print("Employee department and its count :- \n"
                + employeeCountInDepartmentMap);

        // Find the department which has the highest number of employees.
        Optional<Map.Entry<String, Long>> deptNameWithHighestEmp = employeeCountInDepartmentMap.entrySet().stream().max(Map.Entry.comparingByValue());
        if (deptNameWithHighestEmp.isPresent()) {
            System.out.println("Department which has the highest number of employees " + deptNameWithHighestEmp.get());
        }


        // Sorting a Stream by age and name fields
        System.out.println("Sorting based on name and age:: ");
        Comparator<Employee2> comparator1 = Comparator.comparing(Employee2::getName);
        Comparator<Employee2> comparator2 = Comparator.comparingInt(Employee2::getAge);

        empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

        // Highest experienced employees in the organization
        Optional<Employee2> seniorEmp = empList.stream()
                .sorted(Comparator
                        .comparingInt(Employee2::getYearOfJoining)).findFirst();
        System.out.println("Senior Employee Details :" + seniorEmp.get());

        //Print average and total salary of the organization.
        DoubleSummaryStatistics empSalary = empList.stream()
                .collect(Collectors
                        .summarizingDouble(Employee2::getSalary));

        System.out.println("Average Salary in the organisation = " + empSalary.getAverage());
        System.out.println("Total Salary in the organisation  = " + empSalary.getSum());

        //Print Average salary of each department
        System.out.println("Print Average salary of each department");
        Map<String, Double> avgSalary = empList.stream()
                .collect(Collectors.groupingBy
                        (Employee2::getDeptName,
                                Collectors.averagingDouble(Employee2::getSalary)));
        Set<Map.Entry<String, Double>> entrySet = avgSalary.entrySet();
        for (Map.Entry<String, Double> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        //Find Highest salary in the organisation
        Optional<Employee2> empHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee2::getSalary).reversed()).findFirst();

        System.out.println("Highest Salary in the organisation : " + empHighest.get().getSalary());

        //Find Second Highest salary in the organisation
        Optional<Employee2> emp2 = empList.stream()
                .sorted(Comparator.comparingDouble(Employee2::getSalary)
                        .reversed())
                .skip(1)
                .findFirst();

        System.out.println("Second Highest Salary in the organisation : " + emp2.get().getSalary());


        Optional<Employee2> emp3 = empList.stream()
                .sorted(Comparator.comparingDouble(Employee2::getSalary)
                        .reversed())
                .skip(3)
                .findFirst();

        System.out.println("Third Highest Salary  in the organisation : " + emp3.get().getSalary());

        //	Nth Highest salary


        // Find highest paid salary in the organisation based on gender
        Map<String, Optional<Employee2>> highestPaidMFEmployee = empList.stream()
                .collect(Collectors.groupingBy(Employee2::getGender, Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));

        System.out.println("Highest paid male and female employee : " + highestPaidMFEmployee);

        // Find lowest paid salary employee in the organisation based on gender
        Map<String, Optional<Employee2>> lowestPaidMFEmployee = empList.stream()
                .collect(Collectors.groupingBy(Employee2::getGender, Collectors.minBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));

        System.out.println("Lowest paid male and female employee : " + lowestPaidMFEmployee);

        // sort the employees salary in the organisation in ascending order
        System.out.println("Sorting the organisation's employee salary in ascending order ");
        empList.stream().sorted(Comparator.comparingLong(Employee2::getSalary)).toList().forEach(System.out::println);

        // sort the employees salary in the organisation in descending order
        System.out.println("Sorting the organisation's employee salary in descending order ");
        empList.stream().sorted(Comparator.comparingLong(Employee2::getSalary).reversed()).toList().forEach(System.out::println);

        // sort the employees salary in each department in ascending order
        System.out.println("Sorting the department wise employee salary in ascending order:: ");
        Map<String, Stream<Employee2>> sortedEmployeeAsc = empList.stream().collect(Collectors.groupingBy(Employee2::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparingDouble(Employee2::getSalary)))));

        sortedEmployeeAsc.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });

        // sort the employees salary in each department in descending order
        System.out.println("Sorting the department wise employee salary in descending order ");
        Map<String, Stream<Employee2>> sortedEmployeeDesc = empList.stream().collect(Collectors.groupingBy(Employee2::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                list -> list.stream().sorted(Comparator.comparingDouble(Employee2::getSalary).reversed()))));

        sortedEmployeeDesc.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v.collect(Collectors.toList()));
        });

        // Highest salary based on department
        System.out.println("Highest salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee2::getDeptName, Collectors.collectingAndThen(Collectors.toList(),
                list4 -> list4.stream().max(Comparator.comparingDouble(Employee2::getSalary))))));

        //Print list of employee's second highest record based on department
        System.out.println("Highest second salary dept wise:: \n" + empList.stream().collect(Collectors.groupingBy(Employee2::getDeptName,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().
                                sorted(Comparator.comparingDouble(Employee2::getSalary).reversed()).skip(1).findFirst()))));
        
        //The following will classify Employee2 objects by city: 

            Map<String, List<Employee2>> peopleByCity
                = empList.stream().collect(Collectors.groupingBy(Employee2::getCity));

       //The following will classify Employee2 objects by DeptName and city,cascading two Collectors together: 

            Map<String, Map<String, List<Employee2>>> peopleByStateAndCity
                = empList.stream().collect(Collectors.groupingBy(Employee2::getDeptName,
                                                             Collectors.groupingBy(Employee2::getCity)));

    }
}

class Employee2 {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee2(int id, String name, int age, long salary, String gender, String deptName, String city, int yearOfJoining) {
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
        return "Employee2{" +
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