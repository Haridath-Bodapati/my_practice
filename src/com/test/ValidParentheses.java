package com.test;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        char[] openingBrackets = new char[]{'(', '{', '['};
        char[] closingBrackets = new char[]{')', '}', ']'};
        
        for (char ch : charArray) {
            if (isArrayContains(openingBrackets, ch)) {
                stack.push(ch);
            } else if (isArrayContains(closingBrackets, ch)) {
                if (stack.isEmpty() || stack.pop() != getMatchingOpeningBracket(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isArrayContains(char[] array, char ch) {
        for (char c : array) {
            if (c == ch) {
                return true;
            }
        }
        return false;
    }

    private static char getMatchingOpeningBracket(char closingBracket) {
    	switch(closingBracket) {
    		case ')' : System.out.println("this month has 31 days");
    	}
        switch (closingBracket) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return '\0'; // Invalid case
        }
    }

    public static void main(String[] args) {
        String inputString = "[(){}[]]";
        boolean result = isValidParentheses(inputString);
        System.out.println(result);  // Output: true
    }
}
