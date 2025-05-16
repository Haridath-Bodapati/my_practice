package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class StaticTest {
	
	{
		System.out.println("In the non static block");
	}
	
	static{
		System.out.println("THis  is static block loaded with out creating objectS");
	//	StaticTest staticTest = new StaticTest();
		StaticTest.staticVariable=500;
		System.out.println("Static value is "+StaticTest.staticVariable);
	}
	
	static int staticVariable = 10;
	int nonStaticVariable = 20;

	public static void main(String[] args) {
		System.out.println("Static value is "+StaticTest.staticVariable);
		StaticTest staticTest = new StaticTest();
		staticTest = new StaticTest();
		staticTest.staticVariable = 30;
		System.out.println("Static value is "+StaticTest.staticVariable);
	}

}


class ExtendStaticTest extends StaticTest {
	
	int staticVariable = 210;
	
	public static void main(String[] args) {
		try {
			ExtendStaticTest.class.getClass().newInstance();
			Class.forName("com.test.StaticTest").newInstance();
			Constructor c1 = ExtendStaticTest.class.getConstructor(String.class);
			ExtendStaticTest obj1 = (ExtendStaticTest) c1.newInstance("Jesus");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtendStaticTest est = new ExtendStaticTest();
		ExtendStaticTest est1 = (ExtendStaticTest)est.clone();
		System.out.println("1) changed static variable is "+est.staticVariable);
		System.out.println("2) staticVariable value is "+StaticTest.staticVariable);
		System.out.println("3) nonstaticVariable value is "+est.nonStaticVariable);
		est.staticVariable = 30;
		est.nonStaticVariable = 40;
		System.out.println("4) staticVariable value is "+StaticTest.staticVariable);
		System.out.println("5) staticVariable value is "+est.staticVariable);
		System.out.println("6) nonstaticVariable value is "+est.nonStaticVariable);

	}
	
	public Object clone(){
		return new ExtendStaticTest();
		
	}
/*	static int staticVariable = 10;
	public static void main(String[] args) {
		
		int staticVariable = 20;
		
		System.out.println(staticVariable);
		
		StaticTest staticTest = new StaticTest();
		System.out.println(staticTest.staticVariable);
		
		StaticTest st = new StaticTest();
		st.staticVariable = 30;
		System.out.println("3 "+st.staticVariable);
		System.out.println("3 "+StaticTest.staticVariable);

		
	}*/

}