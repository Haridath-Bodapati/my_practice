package com.test;

//only public, abstract, final are allowed
abstract public class CoreTesting {

	public static void main(String[] args) {

		Number[] ob = new Number[5];
		ob[0] = new Float(10.45);
		
		for(Number b: ob) {
			System.out.println("VALUE IS "+b);
		}
		

	}
	
	
	
	

}
