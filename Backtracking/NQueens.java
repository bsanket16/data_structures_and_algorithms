package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {

        int n = 4;
        char[][] mat = new char[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                mat[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();

        solveNQueens(n, 0, mat, ans);
        System.out.println(ans);
    }

    private static void solveNQueens(int n, int col, char[][] mat, List<List<String>> ans) {

        if (col == n) {

            List<String> temp = construct(mat);
            ans.add(temp);
            return;
        }

        for (int i=0; i<n; i++) {

                if (isSafe(mat, i, col)) {

                    mat[i][col] = 'Q';
                    solveNQueens(n, col+1, mat, ans);
                    mat[i][col] = '.';
                }
        }
    }

    private static List<String> construct(char[][] mat) {
        List<String> ans = new ArrayList<>();

        for (char[] row : mat) {
            ans.add(String.valueOf(row));
        }

        return ans;
    }

    public static boolean isSafe(char[][] mat, int row, int col) {

        for (int i=col; i>=0; i--) if (mat[row][i] == 'Q') return false;

        int i = row, j = col;

        while (i>=0 && j>=0) {
            if (mat[i][j] == 'Q') return false;
            i--; j--;
        }

        i = row; j = col;

        while (i<mat.length && j>=0) {
            if (mat[i][j] == 'Q') return false;
            i++; j--;
        }

        return true;
    }

}
