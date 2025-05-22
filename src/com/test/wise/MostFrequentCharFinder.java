package com.test.wise;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Create a function in java that:

ALL

1

1. Accepts a string as input

2. Identifies the character that appears most frequently in the string

3. Returns this character

Requirements:

The string will contain only ASCII characters from the ranges ('a'-'z', 'A'-'Z', '0'-'9').

The function must be case-sensitive ('A' and 'a' are different characters).

If there is a tie for the most frequent character, return the one that appears first in the string.

Example

findMost FrequentChar("abcABCabc") should return 'a'

findMost FrequentChar("1223334444") should return '4'

In the first example, characters 'a', 'b', and 'c' occur twice, and 'a' appears first.

Function Description

Complete the function

maximumOccurringCharacter in the editor with the following parameter:

string text: the string to analyze Returns

char: the most common character that appears first in the string
 */

public class MostFrequentCharFinder {

    public static char maximumOccurringCharacter(String text) {
    	
    	/**
        // Frequency map to count each character
        int[] freq = new int[128]; // ASCII range
        int maxFreq = 0;
        char result = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
            // Update result if this character now has a higher frequency
            // OR if it ties the max but appears earlier
            if (freq[ch] > maxFreq || (freq[ch] == maxFreq && result == 0)) {
                maxFreq = freq[ch];
                result = ch;
            }
        }

        // Handle tie-breaker by finding the first character with max frequency
        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == maxFreq) {
                return text.charAt(i);
            }
        }

        return result; // Fallback (should not happen)**/

    	char mostFrequencyChar = 0;
    	    	
    	try {
    		if(!Objects.isNull(text)) {
    			text = text.replaceAll("\\S+", text);
    			boolean isValidText = text.matches("^[a-zA-Z0-9]+$");
    			if(isValidText) {
    				Optional<Map.Entry<Character, Long>> maxOccuringChar = text.chars().mapToObj(c -> (char) c)
    						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    						.entrySet().stream().max(Map.Entry.comparingByValue());
    				
    				if(maxOccuringChar.isPresent()) {
    					mostFrequencyChar = maxOccuringChar.get().getKey().charValue();
    				}
    			} else {
    				throw new IllegalArgumentException();
    			}
    			
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	 
    	return mostFrequencyChar;
    }

    public static void main(String[] args) {
        System.out.println(maximumOccurringCharacter("abcABCabc")); // Output: a
        System.out.println(maximumOccurringCharacter("1223334444111")); // Output: 4
    }
}

