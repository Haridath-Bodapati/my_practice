package com.test.ibm;

public class BinaryRepresentation {
    
    public static String toBinary(int n) {
        StringBuilder binary = new StringBuilder();
        
        if (n == 0) {
            return "0";
        }
        
        while (n > 0) {
            int bit = n % 2;
            binary.insert(0, bit); // Insert the bit at the beginning of the string
            n = n / 2;
        }
        
        return binary.toString();
    }

    public static void main(String[] args) {
        int number = 5;
        String binaryRepresentation = toBinary(number);
        for(int i =0 ; i < binaryRepresentation.length(); i++) {
        	if(Integer.parseInt(Character.toString(binaryRepresentation.charAt(i)) ) == 1) {
        		
        	}
        	
        }
        System.out.println("Binary representation of " + number + " is: " + binaryRepresentation);
    }
}
