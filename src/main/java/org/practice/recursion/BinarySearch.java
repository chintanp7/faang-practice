package org.practice.recursion;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(arr, 0, arr.length - 1, 40));
    }

    private int binarySearch(int[] arr, int start, int end, int element) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (element < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
