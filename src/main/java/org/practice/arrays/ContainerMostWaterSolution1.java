package org.practice.arrays;

public class ContainerMostWaterSolution1 {
    public static void main(String[] args) {
        int[] array = {7, 1, 2, 3, 9, 8, 4};
        System.out.println("Max area is: " + findMaxWaterArea(array));
    }

    private static int findMaxWaterArea(int[] array) {
        int maxArea = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int area = getArea(array, i, j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private static int getArea(int[] array, int leftIndex, int rightIndex) {
        return Math.min(array[leftIndex], array[rightIndex]) * (rightIndex - leftIndex);
    }
}
