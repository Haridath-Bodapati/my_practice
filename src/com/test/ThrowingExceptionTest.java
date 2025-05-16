package com.test;

public class ThrowingExceptionTest {

	public static void main(String[] args) {
		ThrowingException exception = new ThrowingException();
		try {
			exception.add(1);
		} catch (LogicalException e) {
			System.out.println("Logical Exception");
			e.printStackTrace();
		} 
		try{
			exception.add(2, 3);
		}
		catch (RuntimeException e) {
			System.out.println("Runtime Exception");
			e.printStackTrace();
		}

	}

}
