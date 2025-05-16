package com.test;

public class MultipleInterfaceTest implements InterfaceA, InterfaceB{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void test1() {
		InterfaceA.super.test1();
		
	}

}
