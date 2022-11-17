package org.practice.arrays2d;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOrange {

    public static void main(String[] args) {
        // int[][] grid = {{2, 1, 1, 0, 0}, {1, 1, 0, 0, 2}, {0, 1, 1, 1, 1}, {0, 1, 1, 0, 1}};
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};

        System.out.println("Minute to rotting all oranges: " + new RottingOrange().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        // Initiate variables
        int minutes = 0;
        int fresh = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // Do the sequential search and count the no of fresh oranges and add the rotten orange index to queu
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }

        // Run until queue is empty
        while (!queue.isEmpty()) {
            // Initiate the increase flag with false
            boolean increased = false;
            // Record current queue size
            int size = queue.size();
            // Loop to size to 0
            while (size --> 0) {
                // Get current element from queu
                int[] currentIndex = queue.poll();
                // Move through each direction of current index
                for (int[] dir : directions) {
                    int row = currentIndex[0] + dir[0];
                    int col = currentIndex[1] + dir[1];
                    // if valid index and element is 1 (fresh orange) then, add the index to queue + mark the index as rotten + decrease no of fresh oranges + mark increase flag to true
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 1) {
                        queue.add(new int[]{row, col});
                        grid[row][col] = 2;
                        fresh--;
                        increased = true;
                    }
                }
            }
            // Increase the minute if the increase flag is true
            if (increased) {
                minutes++;
            }
        }

        // Return -1 if any fresh orange remain or the count of minutes otherwise
        if (fresh > 0) {
            return -1;
        } else {
            return minutes;
        }
    }
}
