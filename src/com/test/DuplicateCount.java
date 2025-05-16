package com.test;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCount {

    public static int countDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        char[] chars = input.toLowerCase().toCharArray();

        for (char ch : chars) {
            if (Character.isLetterOrDigit(ch)) {
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }

        int duplicateCount = 0;
        for (int count : charCountMap.values()) {
            if (count > 1) {
                duplicateCount++;
            }
        }

        return duplicateCount;
    }

    public static void main(String[] args) {
        String inputString = "Indivisibilities";
        int result = countDuplicates(inputString);
        System.out.println("Count of duplicates: " + result);  // Output: 6
    }
}

