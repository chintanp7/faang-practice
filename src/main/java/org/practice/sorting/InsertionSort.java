package org.practice.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {6, 7, 2, 0, 9, 3, 4, 1, 8};
        System.out.println("Before sorting: " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    private static void insertionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j --) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
