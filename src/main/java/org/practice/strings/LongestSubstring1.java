package org.practice.strings;

public class LongestSubstring1 {

    public static void main(String[] args) {
        LongestSubstring1 longestSubstring1 = new LongestSubstring1();
        System.out.println("Longest substring 1: " + longestSubstring1.lengthOfLongestSubstring("lyuydifnelqwzrfdvjyyizcczjwosklfigenojauwtqwkybijbgrajwbusqmcbuk"));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();

        int maxLength = 1;


        for (int i = 0; i < arr.length - 1; i++) {
            main:
            for (int j = i; j < arr.length; j++) {
                for (int k = j - 1; k >= i; k--) {
                    System.out.println("i = " + i + " arr[i] = " + arr[i] + ", j = " + j + " arr[j] = " + arr[j] + ", k = " + k + " arr[k] = " + arr[k] );
                    if (arr[k] != arr[j]) {
                        if (j - k + 1 > maxLength) {
                            maxLength = j - k + 1;
                            System.out.println("Max Length = " + maxLength);
                        }
                    } else {
                        break main;
                    }
                }
            }
        }

        return maxLength;
    }
}
