package com.test.wissen;

import java.util.Arrays;
import java.util.List;

public class QuickSort {
	
	
	public void quickSort(Integer[] arr, int startIndex, int endIndex) {
		try {
			if(endIndex > startIndex) {
				int partitionIndex = partition(arr, startIndex, endIndex);
				quickSort(arr, startIndex, partitionIndex - 1);
				quickSort(arr, partitionIndex + 1, endIndex);
			}
		} catch (Exception e) {
			
		}
	}

	private int partition(Integer[] arr, int startIndex, int endIndex) {
		
		int pivot = arr[endIndex];
		int i = startIndex - 1;
		
		for(int j = startIndex; j <= endIndex - 1; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, endIndex);
		return i+1;
	}

	private void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		Integer[] sortingArray = new Integer[] {9,4,6,3,5};
		List<Integer> list = Arrays.asList(sortingArray);
		System.out.println("Before sort "+list);
		quickSort.quickSort(sortingArray, 0, 4);
		System.out.println("After sort "+Arrays.asList(sortingArray));
	}
	

}
