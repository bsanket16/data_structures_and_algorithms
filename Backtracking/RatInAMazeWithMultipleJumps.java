package Backtracking;

import java.util.Arrays;

public class RatInAMazeWithMultipleJumps {
    public static void main(String[] args) {
        int n = 4;

        int[][] maze = {
                {2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}
        };

        solveMaze(maze, n);
    }

    static void solveMaze(int[][] maze, int n) {

        int[][] sol = new int[n][n];

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++){
                sol[i][j] = 0;
            }
        }

        if (!solveMazeUtil(maze, sol, n, 0, 0)) {
            System.out.println("-1");
            return;
        }

        for (int i=0; i<n; i++) {
            System.out.println(Arrays.toString(sol[i]));
        }
    }

    static boolean solveMazeUtil(int[][] maze, int[][] sol, int n, int x, int y) {

        if (x == n-1 && y == n-1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y, n)) {

            sol[x][y] = 1;

            for (int i=1; i <= maze[x][y] && i < n; i++){

                if (solveMazeUtil(maze, sol, n, x+i, y)) return true;

                if (solveMazeUtil(maze, sol, n, x, y+i)) return true;
            }

            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    static boolean isSafe(int[][]maze, int x, int y, int N) {
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] != 0;
    }
}
