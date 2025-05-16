package com.test;

import java.util.Arrays;

public class ShallowCopy {
	public static void main(String[] args) {

        int[] arr1 = {10, 20, 30};
        System.out.println("arr1 Before copying: " + Arrays.toString(arr1));


        int[] arr2 = arr1;
        System.out.println("arr2 After copying: " + Arrays.toString(arr1));

        arr2[0] = 30;
        System.out.println("arr1 after copying and changing an element in arr1: " + Arrays.toString(arr1));
        System.out.println("arr1 after copying and changing an element in arr2: " + Arrays.toString(arr2));

    }

}
