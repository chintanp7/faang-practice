package org.practice.arrays;

public class TrappingRainWater3 {

    public static void main(String[] args) {
        TrappingRainWater3 trappingRainWater3 = new TrappingRainWater3();
        int height1[] = {5, 4, 1, 2};
        int height2[] = {4,2,0,3,2,5};
        int height3[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int height4[] = {9,6,8,8,5,6,3};
        System.out.println("1. Total trapped water is: " + trappingRainWater3.trap(height1));
        System.out.println("2. Total trapped water is: " + trappingRainWater3.trap(height2));
        System.out.println("3. Total trapped water is: " + trappingRainWater3.trap(height3));
        System.out.println("4. Total trapped water is: " + trappingRainWater3.trap(height4));
    }

    public int trap(int[] height) {
        // Initialize total water trapped with value 0
        int totalWater = 0;

        // Initialize left pointer, right pointer, max left value and max right value
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        // Run the loop till left pointer is less than right pointer
        while (leftPointer < rightPointer) {
            // Act on the pointer which has lower value [left or right]
            if (height[leftPointer] <= height[rightPointer]) {
                // Count the trapped water at current pointer
                if (height[leftPointer] <= maxLeft) {
                    // if current pointer value is less or equal than corresponding max then count the value
                    totalWater += getWater(maxLeft, height[leftPointer]);
                } else {
                    // if current value is greater than max value, then replace the max value with current value
                    maxLeft = height[leftPointer];
                }
                // move the pointer to the inward direction
                leftPointer++;
            } else {
                if (height[rightPointer] <= maxRight) {
                    totalWater += getWater(maxRight, height[rightPointer]);
                } else {
                    maxRight = height[rightPointer];
                }
                rightPointer--;
            }
        }

        return totalWater;
    }

    private int getWater(int max, int current) {
        return max - current;
    }
}
