package org.practice.arrays;

public class TrappingRainWater1 {
    public static void main(String[] args) {
        int height1[] = {5, 4, 1, 2};
        int height2[] = {4,2,0,3,2,5};
        int height3[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int height4[] = {9,6,8,8,5,6,3};
        System.out.println("1. Total trapped water is: " + trap(height1));
        System.out.println("2. Total trapped water is: " + trap(height2));
        System.out.println("3. Total trapped water is: " + trap(height3));
        System.out.println("4. Total trapped water is: " + trap(height4));
    }

    private static int trap(int[] height) {
        int totalWater = 0;
        boolean slop = false;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[i - 1]) {
                if (!slop) {
                    startIndex = i - 1;
                    slop = true;
                }
            } else if (slop && height[i] >= height[startIndex]) {
                slop = false;
                endIndex = i;
                totalWater += getWater(height, startIndex, endIndex);
            } else if (slop && height[i] > height[i - 1]) {
                endIndex = i;
            }
        }
        if (slop) {
            //totalWater += getWater(height, startIndex, get2ndHighestIndex(height, startIndex));
            totalWater += getWater(height, startIndex, endIndex);
        }
        return totalWater;
    }

    private static int getWater(int[] height, int startIndex, int endIndex) {
        int water = 0;
        int minHeight = Math.min(height[startIndex], height[endIndex]);
        for (int i = startIndex + 1; i <= endIndex - 1; i++) {
            if (minHeight > height[i]) {
                water += minHeight - height[i];
            }
        }
        return water;
    }

    private static int get2ndHighestIndex(int[] height, int startIndex) {
        int secondHighestIndex = startIndex + 1;

        for (int i = startIndex + 1; i < height.length; i++) {
            if (height[i] >= height[secondHighestIndex]) {
                secondHighestIndex = i;
            }
        }
        return secondHighestIndex;
    }
}
