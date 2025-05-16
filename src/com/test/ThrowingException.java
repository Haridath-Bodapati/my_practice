package com.test;

public class ThrowingException {

	public int add(int a, int b) throws RuntimeException{
		try{
			int cb = 5/0;
			System.out.println("In add two attributes");
		}catch(Exception e){
			throw new RuntimeException();
		}
		return a+0/b;
	}
	
	public int add(int a) throws LogicalException{
		try{
			int b = 5/0;
			System.out.println("In add single attribute");
		}catch(Exception e){
			throw new LogicalException();
		}
		return 1;
	}
	
}
