package org.practice.strings;

public class Palindrome1 {

    public static void main(String[] args) {
        Palindrome1 palindrome1 = new Palindrome1();
        String str = "A man, a plan, a canal: Panama";
        System.out.println("String: " + str + ", Is Palindrome: " + palindrome1.isPalindrome(str));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
