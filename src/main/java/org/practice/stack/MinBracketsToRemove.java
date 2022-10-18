package org.practice.stack;

import lombok.AllArgsConstructor;

import java.util.*;

public class MinBracketsToRemove {

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        MinBracketsToRemove minBracketsToRemove = new MinBracketsToRemove();
        System.out.println(minBracketsToRemove.minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {
        // Initiate a stack to store the opening bracket index
        Stack<Integer> bracketIndexStack = new Stack<>();
        // Initiate a set to store the index to remove
        Set<Integer> removeIndex = new HashSet<>();
        if (s == null) {
            return null;
        }
        char[] strArray = s.toCharArray();

        // Loop through the string array
        for (int i = 0; i < strArray.length; i++) {
            // if the current char is an opening bracket then push the current index to the stack
            if (strArray[i] == '(') {
                bracketIndexStack.push(i);
            } else if (strArray[i] == ')') {
                // if the current char is a closing bracket then if there is no opening bracket index in stack
                // then add the current index to remove index set or pop the top element from stack
                if (bracketIndexStack.isEmpty()) {
                    removeIndex.add(i);
                } else {
                    bracketIndexStack.pop();
                }
            }
        }

        // add all additional opening bracket indexes to remove index set
        if (!bracketIndexStack.isEmpty()) {
            bracketIndexStack.forEach(bracket -> removeIndex.add(bracket));
        }

        String returnStr = "";
        // Remove the characters at the remove index set elements from the string
        if (!removeIndex.isEmpty()) {
            for (int i = 0; i < strArray.length; i++) {
                if (!removeIndex.contains(i)) {
                    removeIndex.remove(i);
                    returnStr += strArray[i];
                }
            }
        } else {
            returnStr = s;
        }
        return returnStr;
    }
}
