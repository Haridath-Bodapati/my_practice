package com.test;

import java.util.Objects;

public class ReversingString {

	public static void main(String args[]) {

		String h = "hari";
		String h1 = "";
		// String s[] = new String[h.length()];
		// int a[][]=new int[2][9];

		
		
		char[] chars = h.toCharArray();
		for(int startIndex = 0,  endIndex = chars.length -1; startIndex < endIndex; startIndex++, endIndex--) {
			swap(chars, startIndex, endIndex);
		}
		
		System.out.println("Reversed string1 is "+ new String(chars));

	}

	static public void swap(char[] charArray, int start, int end) {
		char temp = charArray[start];
		charArray[start] = charArray[end];
		charArray[end] = temp;
	}
}
