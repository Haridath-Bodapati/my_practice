package com.test.jpmc;

import java.util.HashMap;
import java.util.Map;

public class ColorCounter {
    private Map<String, Integer> colorCountMap;

    public ColorCounter() {
        colorCountMap = new HashMap<>();
    }

    public void addColor(String color) {
        colorCountMap.put(color, colorCountMap.getOrDefault(color, 0) + 1);
    }

    public int getColorCount(String color) {
        return colorCountMap.getOrDefault(color, 0);
    }

    public static void main(String[] args) {
        ColorCounter colorCounter = new ColorCounter();

        // Add some color objects
        colorCounter.addColor("Red");
        colorCounter.addColor("Green");
        colorCounter.addColor("Blue");
        colorCounter.addColor("Red");
        colorCounter.addColor("Red");
        colorCounter.addColor("Green");

        // Get counts of each color
        System.out.println("Red count: " + colorCounter.getColorCount("Red"));
        System.out.println("Green count: " + colorCounter.getColorCount("Green"));
        System.out.println("Blue count: " + colorCounter.getColorCount("Blue"));
    }
}
