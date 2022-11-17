package org.practice.arrays2d;

import java.util.ArrayDeque;
import java.util.Queue;

public class NoOfIslands {

    public static void main(String[] args) {
        char[][] islandArr = {{'1','1','0','0','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        NoOfIslands noOfIslands = new NoOfIslands();
        System.out.println("No of islands: " + noOfIslands.numIslands(islandArr));
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        // Initiate grids
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < seen.length; i++) {
            for (int j = 0; j < seen[0].length; j++) {
                seen[i][j] = false;
            }
        }
        int islands = 0;

        // Start sequential scan
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // Increase island count and start BFS if found grid with value '1' and the index is not seen yet
                if (grid[i][j] == '1' && !seen[i][j]) {
                    islands++;
                    bfs(i, j, seen, grid);

                }
            }
        }
        return islands;
    }

    // Breadth first search
    private void bfs(int row, int column, boolean[][] seen, char[][] matrix) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        // Add the current element in the queu
        queue.add(new int[] {row, column});
        while (!queue.isEmpty()) {
            // Poll the first element from the queue
            int[] currentIndex = queue.poll();
            // Traverse through all surrounding elements
            for (int i = 0; i < directions.length; i++) {
                int[] dirIndex = directions[i];
                int[] newIndex = {currentIndex[0] + dirIndex[0], currentIndex[1] + dirIndex[1]};
                traverse(newIndex, matrix, seen, queue);
            }
        }
    }

    private void traverse(int[] index, char[][] matrix, boolean[][] seen, Queue<int[]> queue) {
        int row = index[0];
        int column = index[1];
        // If current element is not out of bound and not seen and is 1, then add to queue and mark as seen
        if (!(row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length || seen[row][column] || matrix[row][column] == '0')) {
            seen[row][column] = true;
            queue.add(index);
        }
    }
}
