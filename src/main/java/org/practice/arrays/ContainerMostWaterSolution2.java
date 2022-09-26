package org.practice.arrays;

public class ContainerMostWaterSolution2 {

    public static void main(String[] args) {
        int[] array = {7, 1, 2, 3, 9, 8, 4};
        System.out.println("Max area is: " + maxArea(array));
    }

    public static int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start < end) {
            int area = getArea(height, start, end);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }

    private static int getArea(int[] array, int leftIndex, int rightIndex) {
        return Math.min(array[leftIndex], array[rightIndex]) * (rightIndex - leftIndex);
    }
}
