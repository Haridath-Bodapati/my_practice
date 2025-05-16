package com.test.jpmc;

public class ReverseString {
	public static void main(String[] args) {
		String stringExample = "1234";
		char str[] = stringExample.toCharArray();
		int start, end = 0;
		//end = str.length - 1;
		for (start = 0, end = str.length - 1; start < end; start++, end--) {
			// Swap characters from leftmost and rightmost
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
		}
		String reversedString = String.valueOf(str);
		System.out.println("Reversed string: " + reversedString);
		
		String reversingString = "343";
		int startIndex = 0, endIndex = reversingString.length() - 1;
		
		char temp ;
		int count = 0;

		/*String palindromeStr  = "545";
		StringBuffer sb = new StringBuffer(palindromeStr);
		
		//char temp = 'c';
		//int startIndex = 0, endIndex = palindromeStr.length() - 1;
		while(startIndex < endIndex) {
			temp = palindromeStr.charAt(endIndex);
			sb.setCharAt(startIndex, palindromeStr.charAt(endIndex));
			sb.setCharAt(endIndex, temp);
			
			startIndex++;
			endIndex--;
			count++;
		}*/
		
		/*while(startIndex < endIndex) {
			temp = reversingString.charAt(startIndex);
			reversedStringSB.setCharAt(startIndex, reversingString.charAt(endIndex));
			reversedStringSB.setCharAt(endIndex, temp);
			endIndex--;
			startIndex++;
			count++;
		}
		System.out.println("Number of times loop executed is "+ count);
		System.out.println("The reversed string "+ sb.toString());*/
	}
}