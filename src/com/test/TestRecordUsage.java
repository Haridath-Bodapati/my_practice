/**
 * 
 */
package com.test;

//Java Program Illustrating a Record class
//defining constructors, instance methods
//and static fields

//Record class
public record TestRecordUsage(int id, String firstName,
                    String lastName)
{

 // Instance fields need to be present in the record's
 // parameters but record can define static fields.
 static int empToken;

 // Constructor 1 of this class
 // Compact Constructor is for doing validations and doing normalization.
 public TestRecordUsage
 {
     if (id < 100) {
         throw new IllegalArgumentException(
             "Employee Id cannot be below 100.");
     }
     if (firstName.length() < 2) {
         throw new IllegalArgumentException(
             "First name must be 2 characters or more.");
     }
 }

 // Constructor 2 of this class
 // Alternative Constructor
 public TestRecordUsage(int id, String firstName)
 {
     this(id, firstName, null);
 }

 // Instance methods
 public void getFullName()
 {
     if (lastName == null)
         System.out.println(firstName());

     else
         System.out.println(firstName() + " "
                            + lastName());
 }

 // Static methods
 public static int generateEmployeeToken()
 {
     return ++empToken;
 }
}