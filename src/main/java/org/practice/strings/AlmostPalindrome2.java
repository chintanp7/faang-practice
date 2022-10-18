package org.practice.strings;

public class AlmostPalindrome2 {

    public static void main(String[] args) {
        AlmostPalindrome2 almostPalindrome1 = new AlmostPalindrome2();
        String str = "aydmda";
        System.out.println("String: " + str + ", Is Palindrome: " + almostPalindrome1.validPalindrome(str));
    }
    public boolean validPalindrome(String s) {
        // Return true if string is empty or single character
        if (s == null || s.isEmpty() || s.length() == 1) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        // loop while left is less or equal to right
        while (l <= r) {
            // if there is single mismatch then call the sub method to check with skipping left and right character
            if (s.charAt(l) != s.charAt(r)) {
                return validSubPalindrome(s, l + 1, r) || validSubPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean validSubPalindrome(String s, int left, int right) {

        // Check for the palindrome for the new strings
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
