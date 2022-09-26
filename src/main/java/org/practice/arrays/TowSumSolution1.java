package org.practice.arrays;

import java.util.Arrays;

public class TowSumSolution1 {

    public static void main(String[] args) {
        int[] array = {1, 3, 7, 9, 5, 2, 12};
        int[] result = getSumIndex(array, 11);
        System.out.println(result == null ? "No pair found" : Arrays.toString(result));
    }

    private static int[] getSumIndex(int[] array, int sum) {
        if (array == null || array.length < 2) {
            return null;
        }
        int[] indexArray = new int[2];

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    indexArray[0] = i;
                    indexArray[1] = j;
                    return indexArray;
                }
            }
        }
        return null;
    }
}
