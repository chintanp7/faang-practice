package org.practice.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring3 {

    public static void main(String[] args) {
        // Uses sliding window
        LongestSubstring3 longestSubstring1 = new LongestSubstring3();
        System.out.println("Longest substring 1: " + longestSubstring1.lengthOfLongestSubstring("lyuydifnelqwzrfdvjyyizcczjwosklfigenojauwtqwkybijbgrajwbusqmcbuk"));
        System.out.println("Longest substring 2: " + longestSubstring1.lengthOfLongestSubstring("abcbda"));
        System.out.println("Longest substring 2: " + longestSubstring1.lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * Find the longest string with non-repeting string
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] arr = s.toCharArray();

        int maxLength = 0;

        // Initialize Map with String key to store the character, and int value to store the index
        Map<Character, Integer> map = new HashMap<>();

        // Initialize left and right pointers with 0
        int l = 0, r = 0;

        // Run while right is less than the length
        while (r < arr.length) {

            // if character is already exists in the map and index of the same character is greater than the left index then move left pointer to the next to current right pointer
            if (map.containsKey(arr[r]) && map.get(arr[r]) >= l) {
                l = map.get(arr[r]) + 1;
            } else {
                // if the current right pointer does not exists in map then get the length between left and right pointer
                int length = r - l + 1;
                if (length > maxLength) {
                    // if current length is greater than max length then replace that
                    maxLength = length;
                }
            }
            // always put the current right index character and character in map
            map.put(arr[r], r);
            r++;
        }

        return maxLength;
    }
}
