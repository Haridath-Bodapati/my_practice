package com.test;

public class SimpleStatic {
	
	static int i=10;
	
	

	public static void main(String... args) {
		SimpleStatic s = new  SimpleStatic();
		s.i=20;
		System.out.println("s.i is "+s.i);
		System.out.println("s.i is "+SimpleStatic.i);
		
		SimpleStatic.i=30;
		System.out.println("s.i is "+s.i);
		System.out.println("s.i is "+SimpleStatic.i);

	}

}
