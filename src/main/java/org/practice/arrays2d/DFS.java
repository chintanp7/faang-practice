package org.practice.arrays2d;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    private int[][] matrix = new int[4][5];
    boolean[][] seen = new boolean[4][5];
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        DFS DFS = new DFS();
        DFS.processBfs();
    }

    private void processBfs() {

        int num = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = num;
                seen[i][j] = false;
                num++;
            }
        }

        List<Integer> list = new ArrayList<>();
        traverse(matrix, 0, 0, seen, list);
        System.out.println(list);
    }

    private void traverse(int[][] matrix, int row, int column, boolean[][] seen, List<Integer> list) {
        // Return if any index is out of bound
        if (row < 0 || row >= matrix.length || column < 0 || column >= matrix[0].length || seen[row][column]) {
            return;
        }
        // Mark the current index element as seen
        seen[row][column] = true;
        // Add the current index element to the return list
        list.add(matrix[row][column]);
        for (int i = 0; i < directions.length; i++) {
            traverse(matrix, row + directions[i][0], column + directions[i][1], seen, list);
        }
    }


}
