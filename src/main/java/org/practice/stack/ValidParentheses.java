package org.practice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "[[]]{{}}()";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println("String: " + s + ", Valid: " + validParentheses.isValid(s));
    }

    private boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');

        Stack<Character> stack = new Stack();

        if (s == null || s.isEmpty()) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char stackChar = stack.pop();
                if (!map.get(stackChar).equals(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
