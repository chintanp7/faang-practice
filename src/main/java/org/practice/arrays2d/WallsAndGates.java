package org.practice.arrays2d;

import java.util.ArrayDeque;
import java.util.Queue;

public class WallsAndGates {

    public static void main(String[] args) {

        int[][] grid = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                        {-1, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                        {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                        {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};
        printArray(grid);
        WallsAndGates wag = new WallsAndGates();
        wag.wallsAndGates(grid);
        System.out.println("-------------------");
        printArray(grid);
    }

    private void wallsAndGates(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size --> 0) {
                int[] currentIndex = queue.poll();
                for (int[] dir : directions) {
                    int row = currentIndex[0] + dir[0];
                    int col = currentIndex[1] + dir[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == Integer.MAX_VALUE) {
                        grid[row][col] = step;
                        queue.add(new int[]{row, col});
                    }
                }
            }
        }
    }

    public static void printArray(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
