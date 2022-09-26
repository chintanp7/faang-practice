package org.practice.arrays;

public class TrappingRainWater2 {

    public static void main(String[] args) {
        TrappingRainWater2 trappingRainWater2 = new TrappingRainWater2();
        int height1[] = {5, 4, 1, 2};
        int height2[] = {4,2,0,3,2,5};
        int height3[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int height4[] = {9,6,8,8,5,6,3};
        System.out.println("1. Total trapped water is: " + trappingRainWater2.trap(height1));
        System.out.println("2. Total trapped water is: " + trappingRainWater2.trap(height2));
        System.out.println("3. Total trapped water is: " + trappingRainWater2.trap(height3));
        System.out.println("4. Total trapped water is: " + trappingRainWater2.trap(height4));
    }

    public int trap(int[] height) {
        int totalWater = 0;

        for (int i = 0; i < height.length; i++) {
            int maxL = i;
            int maxR = i;
            for (int j = i; j >= 0; j--) {
                if (height[j] > height[maxL]) {
                    maxL = j;
                }
            }
            for (int j = i; j < height.length; j++) {
                if (height[j] > height[maxR]) {
                    maxR = j;
                }
            }
            int minHeight = Math.min(height[maxL], height[maxR]);
            //totalWater += Math.max(minHeight - height[i], 0);
            totalWater += minHeight - height[i];
        }

        return totalWater;
    }
}
