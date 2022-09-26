package org.practice.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = {6, 7, 2, 0, 9, 3, 4, 1, 8};
        System.out.println("Before sorting: " + Arrays.toString(array));
        mergeSort(array);
        System.out.println("After sorting: " + Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        // Size of child arrays
        int n1 = m - l + 1;
        int n2 = r - m;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[m + 1 + j];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }

    }
}
