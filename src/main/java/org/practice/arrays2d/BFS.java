package org.practice.arrays2d;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private int[][] matrix = new int[4][5];
    boolean[][] seen = new boolean[4][5];
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private Queue<int[]> queue = new ArrayDeque<>();
    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.processBfs();
    }

    private void processBfs() {
        int num = 1;
        // Fill the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = num;
                seen[i][j] = false;
                num++;
            }
        }

        // Add the start element index to the queue
        queue.add(new int[]{2, 2});
        while (!queue.isEmpty()) {
            // Get the queue element i.e. indexes of next element
            int[] currentIndex = queue.poll();
            // Traverse to the all direction of current element
            for (int i = 0; i < directions.length; i++) {
                int[] dirIndex = directions[i];
                int[] newIndex = new int[] {currentIndex[0] + dirIndex[0], currentIndex[1] + dirIndex[1]};
                traverse(newIndex);
            }
        }
        System.out.println(list);
    }

    private void traverse(int[] indexArr) {
        int row = indexArr[0];
        int column = indexArr[1];
        // If the index is not out of bound then mark them as seen, add in the return list and add to the queue
        if (!(row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length || seen[row][column])) {
            seen[row][column] = true;
            list.add(matrix[row][column]);
            queue.add(indexArr);
        }
    }
}
