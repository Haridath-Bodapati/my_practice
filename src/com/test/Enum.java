package com.test;

public class Enum {
	// Java program to demonstrate working of values(),
	// ordinal() and valueOf()

	enum Color {
		RED, GREEN, BLUE;
	}

	public static void main(String[] args) {
		// Calling values()
		Color arr[] = Color.values();

		// enum with loop
		for (Color col : Color.values()) {
			// Calling ordinal() to find index of color.
			System.out.println(col + " at index " + col.ordinal());
		}

		// Using valueOf(). Returns an object of Color with given constant.
		// Uncommenting second line causes exception
		// IllegalArgumentException
		Color c = Color.valueOf("RED");
		System.out.println("C is "+c.getDeclaringClass());
		System.out.println(Color.valueOf("RED"));
		// System.out.println(Color.valueOf("WHITE"));
	}
}
