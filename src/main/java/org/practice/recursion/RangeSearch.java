package org.practice.recursion;

/**
 * Find the range of search character (start index and end index)
 */
public class RangeSearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 5, 5, 5, 5, 5, 5, 5, 6, 7};
        RangeSearch rangeSearch = new RangeSearch();
        int[] response = rangeSearch.searchRange(arr, 7);
        System.out.println("[x, y] = [" + response[0] + ", " + response[1] + "]");
    }

    private int[] searchRange(int[] nums, int target) {
        // Initialize the return array and default left and right index
        int[] returnArr = new int[2];
        int leftIndex = -1;
        int rightIndex = -1;
        // Search for the left index using binary search
        leftIndex = searchLeft(nums, target, leftIndex, 0, nums.length - 1);
        // Search for the right index using binary search
        rightIndex = searchRight(nums, target, rightIndex, 0, nums.length - 1);
        returnArr[0] = leftIndex;
        returnArr[1] = rightIndex;
        return returnArr;
    }

    private int searchLeft(int[] nums, int target, int leftIndex, int left, int right) {
        // Search until left <= right
        while (left <= right) {
            // get middle element
            int mid = (left + right) / 2;
            // if middle element is equal to target, then if left index is pointing to the element to the right previously,
            // only then shift left index to the middle element found
            if (nums[mid] == target) {
                if (leftIndex == -1 || leftIndex > mid) {
                    leftIndex = mid;
                }
                right = mid - 1;
            } else if (nums[mid] > target) {
                // if the middle element is greater than the target then discard the right portion of array and search again
                right = mid - 1;
            } else {
                // if the middle element is less than the target then discard the left portion of array and search again
                left = mid + 1;
            }
        }
        return leftIndex;
    }

    private int searchRight(int[] nums, int target, int rightIndex, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (rightIndex == -1 || rightIndex < mid) {
                    rightIndex = mid;
                }
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return rightIndex;
    }
}
