package org.practice.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {6, 7, 2, 0, 9, 3, 4, 1, 8};
        System.out.println("Before sorting: " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j ++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
