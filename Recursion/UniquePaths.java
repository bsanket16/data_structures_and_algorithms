package Recursion;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(countPaths(m,n, 0, 0));
        int[][] dp = new int[m][n];

        for (int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(countPathsDP(m,n, 0, 0, dp));

        System.out.println(countPathsCombinatorics(m, n));
    }

    static int countPathsDP(int m, int n, int row, int col, int[][] dp) {
        if (row == m || col == n) return 0;

        if (row == m-1 && col == n-1) return 1;

        if (dp[row][col] != -1) return dp[row][col];
        else return dp[row][col] = countPathsDP(m, n, row+1, col, dp) + countPathsDP(m, n, row, col+1, dp);
    }

    static int countPaths(int m, int n, int row, int col) {

        if (row == m || col == n) return 0;

        if (row == m-1 && col == n-1) return 1;

        int right = countPaths(m, n, row, col+1);
        int bottom = countPaths(m, n, row+1, col);

        return right + bottom;
    }

    static int countPathsCombinatorics(int m, int n) {

        int N = 28;
        int r = 10;

        double res = 1;

        for (int i=1; i<=r; i++) {
            res = res * (N - r + i) / i;
        }

        return (int) res;
    }
}
