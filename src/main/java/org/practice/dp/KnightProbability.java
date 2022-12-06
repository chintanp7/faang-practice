package org.practice.dp;

import java.util.Arrays;

public class KnightProbability {

    int[][] directions = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public static void main(String[] args) {
        KnightProbability kp = new KnightProbability();
        int n = 3;
        int k = 2;
        int row = 0;
        int col = 0;
        double[][] dp = new double[n][n];
        for (double[] dpRow : dp) {
            Arrays.fill(dpRow, -1.0);
        }
        System.out.println("Probability: " + kp.knightProbability(3, 2, 0, 0, dp));
    }

    public double knightProbability(int n, int k, int row, int column, double[][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        double probability = 0;
        for (int i = 0; i < directions.length; i++) {
            int[] dir = directions[i];
            int currRow = row + dir[0];
            int currCol = column + dir[1];
            if (dp[currRow][currCol] < 0.0) {
                dp[currRow][currCol] = knightProbability(n, k - 1, row + dir[0], column + dir[1], dp) / 8;
            }
            probability += dp[currRow][currCol];
        }
        return probability;
    }
}
