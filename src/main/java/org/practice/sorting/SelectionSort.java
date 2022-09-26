package org.practice.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {6, 7, 2, 0, 9, 3, 4, 1, 8};
        System.out.println("Before sorting: " + Arrays.toString(array));
        selectionSort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallestIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            if (smallestIndex != i) {
                int temp = array[smallestIndex];
                array[smallestIndex] = array[i];
                array[i] = temp;
            }
        }
    }
}
