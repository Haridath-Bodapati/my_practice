package com.java8;


public class SumOfEvenAndOddIndices_Copilot2 {
    public static void main(String[] args) {
        //int[] arr = new int[] {1,1,1};
        int[] arr = new int[] {2,1,6,4};
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
        int res = 0;
        int newEvenNumbersSum, newOddNumbersSum;

        for (int i = 1; i < length - 1; i++) {
            if (i % 2 == 1) {
                currOdd += arr[i];
                newEvenNumbersSum = currEven + oddNumbersSum - currOdd;
                newOddNumbersSum = currOdd + evenNumbersSum - currEven - arr[i];
            } else {
                currEven += arr[i];
                newOddNumbersSum = currOdd + evenNumbersSum - currEven;
                newEvenNumbersSum = currEven + oddNumbersSum - currOdd - arr[i];
            }
            if (newEvenNumbersSum == newOddNumbersSum) {
                res++;
            }
        }

        if (oddNumbersSum == evenNumbersSum - arr[0]) {
            res++;
        }

        if (length % 2 == 1) {
            if (oddNumbersSum == evenNumbersSum - arr[length - 1]) {
                res++;
            }
        } else {
            if (evenNumbersSum == oddNumbersSum - arr[length - 1]) {
                res++;
            }
        }

        return res;
    }
}
