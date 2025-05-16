package com.test.onwardgroup;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CouponGenerator {
    
    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String ALL_CHARACTERS = CAPITAL_LETTERS + NUMBERS + "abcdefghijklmnopqrstuvwxyz";
    private static final int COUPON_LENGTH = 10;
    private static final int TOTAL_COUPONS = 10;

    public static void main(String[] args) {
        Set<String> coupons = new HashSet<>();
        Random random = new Random();

        while (coupons.size() < TOTAL_COUPONS) {
            StringBuilder coupon = new StringBuilder(COUPON_LENGTH);
            
            // Ensure at least one capital letter
            coupon.append(CAPITAL_LETTERS.charAt(random.nextInt(CAPITAL_LETTERS.length())));
            
            // Ensure at least one number
            coupon.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

            // Fill the remaining characters
            for (int i = 2; i < COUPON_LENGTH; i++) {
                coupon.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
            }
            
            // Shuffle the coupon to avoid predictable patterns
            String shuffledCoupon = shuffleString(coupon.toString(), random);
            
            //String shuffledCoupon = coupon.toString();
            
            // Add the coupon to the set (Set ensures uniqueness)
            coupons.add(shuffledCoupon);
        }

        // Print all unique coupons
        for (String coupon : coupons) {
            System.out.println(coupon);
        }
    }

    private static String shuffleString(String input, Random random) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = random.nextInt(characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;
        }
        return new String(characters);
    }
}

