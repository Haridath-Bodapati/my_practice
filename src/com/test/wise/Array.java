package com.test.wise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Array {
	
	public static void main(String[] args) {
		int arr[] = new int[] {1,2,3,4};
		int n = 2;
		arr = Arrays.stream(arr).limit(n).toArray();
		Stream.of(arr);
		
		System.out.println(arr.length);
	}
	
	

}
