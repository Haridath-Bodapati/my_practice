package com.test;

public class EqualSumIndex {

    public static int findEqualSumIndex(int[] arr) {
        /*if (arr == null || arr.length < 3) {
            return -1; // Not enough elements to have a valid index
        }

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];

            if (leftSum == totalSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1; // No index found*/

    	if(arr == null || arr.length < 3) {
    		return -1;
    	}
    	
    	int totalSum = 0;
    	for(int num : arr) {
    		totalSum += num;
    	}
    	
    	int leftSum = 0;
    	
    	for(int i = 0; i < arr.length; i++) {
    		totalSum -= arr[i];
    		if(leftSum == totalSum) {
    			return i;
    		}
    		
    		leftSum += arr[i];
    	}
    	
    	return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1};
        int result = findEqualSumIndex(array);
        System.out.println("Equal sum index: " + result);  // Output: 3
    }
}
