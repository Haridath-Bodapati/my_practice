package com.test;

public class BinarySearch {

	// Returns index of x if it is present in arr[].
	/*int binarySearch(int arr[], int x) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int middle = low + (high - low) / 2;

			// Check if x is present at mid
			if (arr[middle] == x)
				return middle;

			// If x greater, ignore left half
			if (arr[middle] < x)
				low = middle + 1;

			// If x is smaller, ignore right half
			else
				high = middle - 1;
		}

		// If we reach here, then element was
		// not present
		return -1;
	}*/
	
	int binarySearch(int arr[], int finder) {
		
		int low = 0, high = arr.length - 1;
		
		while(low <= high) {
			int middle = low + (high - low) / 2;
			
			if(arr[middle] == finder)
				return middle;
			
			if(arr[middle] < finder)
				low = middle + 1;
			else
				high = middle - 1;
		}
		
		return -1	;
		
	}

	// Driver code
	public static void main(String args[]) {
		BinarySearch ob = new BinarySearch();
		int arr[] = { 2, 3, 4, 10, 40 };
		int x = 4;
		int result = ob.binarySearch(arr, x);
		if (result == -1)
			System.out.println("Element is not present in array");
		else
			System.out.println("Element is present at " + "index " + result);
	}

}
