package com.test.wissen;

public class BinarySearch {
	
	public int binarySearch(int[] a, int low, int high) {
		
		if(high >= low) {
			
			int medium = low + (high - low) / 2;
			
			int x = 0;
			if(a[medium] == x) {
				return medium;
			} else {
				if(x < a[medium]) {
					return binarySearch(a, low, medium - 1);
				} 
				return binarySearch(a, medium + 1, high);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
