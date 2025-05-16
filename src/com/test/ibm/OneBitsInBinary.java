package com.test.ibm;

import java.util.ArrayList;
import java.util.List;

public class OneBitsInBinary {

    public static void main(String[] args) {
        int n = 37; // Example: Replace with your desired integer 'n'
        int[] result = getOneBits(n);
        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] getOneBits(int n) {
        int count = 0;
        List<Integer> positions = new ArrayList<>();

        for (int i = 0; i < 32; i++) { // Iterate through all bits
            if ((n & (1 << i)) != 0) {
                count++;
                positions.add(i + 1); // Adding 1 to convert from 0-based index to 1-based index
            }
        }

        int[] result = new int[positions.size() + 1];
        result[0] = count;
        for (int i = 0; i < positions.size(); i++) {
            result[i + 1] = positions.get(i);
        }
        return result;
    }
}

