package com.backbase;

import java.util.*;

class Solution {
    public int solution(int[] A) {
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        
        // Add each item to the set if it's positive
        for (int i = 0; i < N; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
            }
        }
        
        // Start from 1 and check for the smallest missing positive integer
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        
        // If all positive integers up to N are present, return N+1
        return N + 1;
    }
    
    public static void main(String args[]) {
    	Solution solution = new Solution();
    	int[] A1 = {1, 3, 6, 4, 1, 2};
        System.out.println(solution.solution(A1)); // Output: 5
        
        int[] A2 = {1, 2, 3};
        System.out.println(solution.solution(A2)); // Output: 4
        
        int[] A3 = {-1, -3};
        System.out.println(solution.solution(A3)); // Output: 1
    }
}
