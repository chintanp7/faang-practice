package org.practice.strings;

import java.util.Stack;

public class TypedOutString1 {

    public static void main(String[] args) {
        TypedOutString1 typedOutString1 = new TypedOutString1();
        System.out.println(typedOutString1.backspaceCompare("abcd", "bbcd"));
    }

    public boolean backspaceCompare(String s, String t) {

        if (s.equals(t)) {
            return true;
        }

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(chars1[i]);
            }
        }

        for (int i = 0; i < chars2.length; i++) {
            if (chars2[i] == '#') {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(chars2[i]);
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
