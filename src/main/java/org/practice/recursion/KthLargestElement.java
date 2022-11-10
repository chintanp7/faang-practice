package org.practice.recursion;

public class KthLargestElement {

    public static void main(String[] args) {

        int[] arr = {5, 7, 3, 4, 1, 2, 6};
        int k = 6;
        // Get Array Index of Kth largest element
        int index = arr.length - k;
        KthLargestElement kthLargestElement = new KthLargestElement();
        // Call Quicksort
        int kthElement = kthLargestElement.quickSort(arr, 0, arr.length - 1, index);
        System.out.println("Kth Largest Element: " + arr[kthElement]);
    }

    public int quickSort(int[] arr, int left, int right, int k) {
        int partitionIndex = partition(arr, left, right);
        if (k < partitionIndex) {
            return quickSort(arr, left, partitionIndex - 1, k);
        } else if (k > partitionIndex) {
            return quickSort(arr, partitionIndex + 1, right, k);
        }
        return partitionIndex;
    }

    private int partition(int[] arr, int left, int right) {
        int partitionIndex = left;
        int pivet = arr[right];

        for (int j = left; j <= right; j++) {
            if (arr[j] < pivet) {
                swap(arr, j, partitionIndex);
                partitionIndex++;
            }
        }

        swap(arr, partitionIndex, right);
        return partitionIndex;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
