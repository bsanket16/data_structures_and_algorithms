package Backtracking;

public class NQueens2 {
    public static void main(String[] args) {

        int n = 4;
        char[][] mat = new char[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                mat[i][j] = '.';
            }
        }

        System.out.println(solveNQueens(n, 0, mat, 0));
    }

    private static int solveNQueens(int n, int col, char[][] mat, int count) {

        if (col == n) {

            count++;
            return count;
        }

        for (int i=0; i<n; i++) {

            if (isSafe(mat, i, col)) {

                mat[i][col] = 'Q';
                count = solveNQueens(n, col+1, mat, count);
                mat[i][col] = '.';
            }
        }

        return count;
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
