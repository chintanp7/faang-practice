package org.practice.strings;

public class TypedOutString4 {

    public static void main(String[] args) {
        TypedOutString4 typedOutString1 = new TypedOutString4();
        System.out.println(typedOutString1.backspaceCompare("ab##", "c#d#"));
    }

    public boolean backspaceCompare(String s, String t) {
        // Initialize the pointers to the length of strings
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;

        // Run until any of the pointer is greater than 0
        while (p1 >= 0 || p2 >= 0) {
            // Check if any pointer is pointing at '#'
            if (s.charAt(p1) == '#' || t.charAt(p2) == '#') {
                if (s.charAt(p1) == '#') {
                    // If pointer is at '#' increase back-count to 2
                    int backCount = 2;
                    // While backcount is greater than 0 decrease the pointer and the backCount and also add 2 if there is any '#' found
                    while (backCount > 0) {
                        p1--;
                        backCount--;
                        if (s.charAt(p1) == '#') {
                            backCount += 2;
                        }
                    }
                }

                if (t.charAt(p2) == '#') {
                    int backCount = 2;
                    while (backCount > 0) {
                        p2--;
                        backCount--;
                        if (t.charAt(p2) == '#') {
                            backCount += 2;
                        }
                    }
                }
            } else {
                // If pointers are pointing to normal characters then compare the characters
                if (s.charAt(p1) != t.charAt(p2)) {
                    return false;
                } else {
                    p1--;
                    p2--;
                }
            }
        }
        return true;
    }
}
