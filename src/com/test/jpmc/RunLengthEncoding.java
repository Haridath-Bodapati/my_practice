package com.test.jpmc;

public class RunLengthEncoding {

    public static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int count = 1;

        // Traverse the input string
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1)).append(count);
                count = 1; // reset count
            }
        }

        // Append the last group
        result.append(input.charAt(input.length() - 1)).append(count);

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "ee";
        String output = compressString(input);
        System.out.println("Output: " + output); // a3b2c1d3e1
    }
}
