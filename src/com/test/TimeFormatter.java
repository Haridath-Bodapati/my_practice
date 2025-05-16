package com.test;
public class TimeFormatter {

    public static String formatTime(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Input must be a non-negative integer.");
        }

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }

    public static void main(String[] args) {
        int inputSeconds = 601; // Example input, change as needed
        String formattedTime = formatTime(inputSeconds);
        System.out.println(formattedTime);  // Output: 01:01:05
    }
}
