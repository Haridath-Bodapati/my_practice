package com.java8;


public class SumOfEvenAndOddIndices_Copilot {

	
	// 1) Find sum of evens and odd by iterating the array
	// 2) 
	public static void main(String[] args) {
		int[] arr = new int[] {1,1,1};
	//	int[] arr = new int[] {2,1,6,4};
		System.out.println(countIndicesToMakeBalance(arr));
	}

	public static int countIndicesToMakeBalance(int[] arr) {
		int length = arr.length;
		if (length == 1) {
			return 1;
		}
		if (length == 2) {
			return 0;
		}

		int evenNumbersSum = 0;
		int oddNumbersSum = 0;
		for (int i = 0; i < length; i++) {
			if (i % 2 == 0) {
				evenNumbersSum += arr[i];
			} else {
				oddNumbersSum += arr[i];
			}
		}

		int currOdd = 0;
		int currEven = arr[0];
		int result = 0;
		int newEvenNumbersSum, newOddNumbersSum;

		for (int i = 1; i < length - 1; i++) {
			if (i % 2 == 1) {
				currOdd = currOdd + arr[i];
				newEvenNumbersSum = currEven + oddNumbersSum - currOdd;
				newOddNumbersSum = currOdd + evenNumbersSum - currEven - arr[i];
			} else {
				currEven = currEven + arr[i];
				newEvenNumbersSum = currEven + oddNumbersSum - currOdd - arr[i];
				newOddNumbersSum = currOdd + evenNumbersSum - currEven;
			}
			if (newEvenNumbersSum == newOddNumbersSum) {
				result++;
			}
		}

		if (oddNumbersSum == evenNumbersSum - arr[0]) {
			result++;
		}

		if (length % 2 == 1) {
			if (oddNumbersSum == evenNumbersSum - arr[length - 1]) {
				result++;
			}
		} else {
			if (evenNumbersSum == oddNumbersSum - arr[length - 1]) {
				result++;
			}
		}

		return result;
	}

}
