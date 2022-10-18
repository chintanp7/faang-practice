package org.practice.strings;

public class AlmostPalindrome1 {

    public static void main(String[] args) {
        AlmostPalindrome1 almostPalindrome1 = new AlmostPalindrome1();
        String str = "aydmda";
        System.out.println("String: " + str + ", Is Palindrome: " + almostPalindrome1.validPalindrome(str));
    }



    public boolean validPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return true;
        }

        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            if (arr[l] != arr[r]) {
                return isPalindrome((l > 0 ? s.substring(0, l) : "") + s.substring(l + 1))||
                        isPalindrome(s.substring(0, r) + (r < s.length() ? s.substring(r + 1) : ""));
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        /*if (s == null || s.isEmpty() || s.length() == 1) {
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();*/

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
