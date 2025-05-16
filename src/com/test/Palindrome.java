package com.test;

public class Palindrome {

	public static void main(String[] args) {
		int num = 505;

		int actualNum = num;
		int sum = 0;
		int r = -1;
		
		while(num > 0) {
			r = num % 10;
			sum = sum * 10 + r;
			num = num / 10;
		}

		if(sum == actualNum) {
			System.out.println("Num is palindrome");
		}
	}

}
