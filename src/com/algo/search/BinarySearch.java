package com.algo.search;

public class BinarySearch {
    int binarySearch(int arr[], int left, int right, int searchElement) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.println("The mid value is "+mid);
            /*if (arr[mid] == searchElement)
                return mid;
            if (arr[mid] > searchElement)
            	// If target is less than mid, ignore right list
            	// If mid is greater than searchelement ignore right
                return binarySearch(arr, left, mid - 1, searchElement);
            	// If target is greater than mid, ignore left list
            	// If mid is less than searchelement ignore left
            return binarySearch(arr, mid + 1, right, searchElement);*/
            
            if (searchElement == arr[mid] )
                return mid;
            if (searchElement < arr[mid] )
            	// If target is less than mid, ignore right list
            	// If mid is greater than searchelement ignore right
                return binarySearch(arr, left, mid - 1, searchElement);
            	// If target is greater than mid, ignore left list
            	// If mid is less than searchelement ignore left
            return binarySearch(arr, mid + 1, right, searchElement);
        }
        return -1;
    }
    
    int binarySearch1(int[] arr, int left, int right, int searchElement) {
		return searchElement;
    	
    }

    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int length = arr.length;
        int x = 4;
        int result = ob.binarySearch(arr, 0, length - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}