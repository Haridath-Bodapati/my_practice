package com.test.jpmc;

public class ReverseString {
	public static void main(String[] args) {
		String stringExample = "1234";
		int startIndex = 0, endIndex = stringExample.length() - 1;
		
		char[] chars = stringExample.toCharArray();

		while (startIndex < endIndex) {
			char temp = stringExample.charAt(startIndex);
			chars[startIndex] = chars[endIndex];
			chars[endIndex] = temp;
			
			startIndex++;
			endIndex--;
		}
		
		stringExample = String.valueOf(chars);

		System.out.println("Reversed string is " + stringExample);
	}
}