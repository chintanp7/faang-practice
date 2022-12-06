package org.practice.dp;

public class KnightProbability2 {

    int[][] directions = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public static void main(String[] args) {

        int n = 6;
        int k = 3;
        int row = 2;
        int col = 3;

        KnightProbability2 kp2 = new KnightProbability2();
        System.out.println("Probability is: " + kp2.knightProbability(n, k, row, col));
    }

    public double knightProbability(int n, int k, int row, int column) {

        double[][][] dp = new double[k][n][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    dp[i][j][l] = -1.0;
                }
            }
        }

        return recursive(n, k, row, column, dp);
    }

    double recursive(int n, int k, int row, int column, double[][][] dp) {
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        if (dp[k - 1][row][column] < 0) {
            double result = 0.0;
            for (int i = 0; i < directions.length; i++) {
                int[] dir = directions[i];
                result += recursive(n, k - 1, row + dir[0], column + dir[1], dp) / 8.0;
            }
            dp[k - 1][row][column] = result;
        }
        return dp[k - 1][row][column];
    }
}
