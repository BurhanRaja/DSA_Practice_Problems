package com.Burhan;

import java.util.Stack;

public class Paranthesis_Palindrome {
    public static void main(String[] args) {
        String str = "(({{}}))";
        boolean ans = palindromeP(str);
        System.out.println(ans);
    }

    static boolean palindromeP(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);

            if (a=='(' || a=='{' || a=='[') {
                s.add(a);
                continue;
            }

            if (s.isEmpty()) {
                return false;
            }
            else if (isPalindrome(s.peek(), a)) {
                s.pop();
            }
            else {
                return false;
            }
        }

        return true;
    }

    static boolean isPalindrome(char a, char b) {
        return a=='(' && b==')' || a=='{' && b=='}' || a=='[' && b==']';
    }
}