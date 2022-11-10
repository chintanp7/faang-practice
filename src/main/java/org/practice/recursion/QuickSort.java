package org.practice.recursion;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {70, 40, 100, 10, 20, 80, 90, 50, 30, 20, 60};
        QuickSort quickSort = new QuickSort();
        quickSort.printArray(array);
        quickSort.quickSort(array, 0, array.length - 1);
        System.out.println("After sorting...");
        quickSort.printArray(array);
    }

    private void quickSort(int[] arr, int low, int high) {
        // Call the recursion with partitioning until low and high get matched
        if (low < high) {
            // Get partition index by getting pivot index after operation
            int partitionIndex = partition(arr, low, high);

            // Recursive call for the partitions
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {

        // Take Last element of partition as pivot
        int pivot = arr[high];

        // Take i as out of lower index boundry
        int i = low - 1;

        // Loop through each element in partition except pivot
        for (int j = low; j < high; j++) {
            // Compare each element with pivot
            if (arr[j] < pivot) {
                // if element is less than pivot then increase value of i and swap the array element at i and j index.
                // In this case when arr[j] is less than pivot, arr[j] will be shifted to the left of current i index
                i++;
                swap(arr, i, j);
            }
        }
        // Swap the pivot with current i + 1 element.
        // Based on previous operation the i has been increased only when we find the element less than pivot
        // And we have shifted all smaller element than pivot to the left side upto index i
        // so that shifting pivot to i+1 will make sure all small element to the left and big element to the right
        swap(arr, i + 1, high);

        // return the pivot index as a partition index as the pivot place is fixed now so no need to move it anymore
        return i + 1;

    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void printArray(int[] arr) {
        Arrays.stream(arr).forEach(i -> System.out.print(i + ", "));
    }
}
