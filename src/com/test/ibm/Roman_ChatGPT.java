package com.test.ibm;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Roman_ChatGPT {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(8); // Example input list of numbers
        List<String> romanNumerals = integersToRoman(numbers);
        System.out.println("Roman numeral equivalents: " + romanNumerals);
    }

    public static List<String> integersToRoman(List<Integer> numbers) {
        List<String> romanNumerals = new ArrayList<>();
        for (int num : numbers) {
            romanNumerals.add(intToRoman(num));
        }
        return romanNumerals;
    }

    public static String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int key = map.floorKey(num);
            String roman = map.get(key);
            sb.append(roman);
            num -= key;
        }
        return sb.toString();
    }
}
