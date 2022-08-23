package Backtracking;

import java.util.Arrays;

public class RatInAMaze {
    public static void main(String[] args) {
        int n = 4;

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int[][] sol = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                sol[i][j] = 0;
            }
        }

        solveMaze(maze, sol);
    }

    static void solveMaze(int[][] maze, int[][] sol) {

        int n = maze.length;

        if (!solveMazeRec(maze, sol, 0, 0, n)) {
            System.out.println("No Solution");
            return;
        }

        for (int i=0; i<n; i++){
            System.out.println(Arrays.toString(sol[i]));
        }
    }

    static boolean isSafe(int[][] maze, int x, int y, int n) {
        return (x>= 0 && x < n  && y >= 0 && y < n && maze[x][y] == 1);
    }

    static boolean solveMazeRec(int[][] maze, int[][] sol, int x, int y, int n) {

        if (x == n-1 && y == n-1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(maze, x, y, n)) {

            if (sol[x][y] == 1)
                return false;

            sol[x][y] = 1;

            if (solveMazeRec(maze, sol, x + 1, y, n))
                return true;

            if (solveMazeRec(maze, sol, x, y + 1, n))
                return true;

            if (solveMazeRec(maze, sol, x - 1, y, n))
                return true;

            if (solveMazeRec(maze, sol, x, y - 1, n))
                return true;

            sol[x][y] = 0;
            return false;
        }
        return false;
    }
}
