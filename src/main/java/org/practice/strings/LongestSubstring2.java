package org.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring2 {

    public static void main(String[] args) {
        LongestSubstring2 longestSubstring1 = new LongestSubstring2();
        System.out.println("Longest substring 1: " + longestSubstring1.lengthOfLongestSubstring("lyuydifnelqwzrfdvjyyizcczjwosklfigenojauwtqwkybijbgrajwbusqmcbuk"));
        System.out.println("Longest substring 2: " + longestSubstring1.lengthOfLongestSubstring("abcbda"));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();

        int maxLength = 0;

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int length = 0;
            for (int j = i; j < arr.length; j++) {
                if (!map.containsKey(arr[j])) {
                    map.put(arr[j], arr[j]);
                    length++;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                } else {
                    break;
                }
            }
            map.clear();
        }

        return maxLength;
    }
}
