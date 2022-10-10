package org.practice.strings;

import java.util.Stack;

public class TypedOutString2 {

    public static void main(String[] args) {
        TypedOutString2 typedOutString1 = new TypedOutString2();
        System.out.println(typedOutString1.backspaceCompare("abcd", "bbcd"));
    }

    public boolean backspaceCompare(String s, String t) {

        if (s.equals(t)) {
            return true;
        }

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(t.charAt(i));
            }
        }

        if (stack1.size() != stack2.size()) {
            return false;
        }

        int size = stack1.size();

        for (int i = 0; i < size; i++) {
            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }
        return true;
    }
}
