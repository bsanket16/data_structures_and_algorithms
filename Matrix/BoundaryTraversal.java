package Matrix;

import java.util.Scanner;

public class BoundaryTraversal {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] arr = new int[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        int R = arr.length, C = arr[R-1].length;

        if (R==1) {
            for (int i=0; i<C; i++) {
                System.out.print(arr[0][i]);
            }
        }

        else if (C==1) {
            for (int i=0; i<R; i++) {
                System.out.print(arr[i][0]);
            }
        }

        else {
            for(int i = 0; i < C; i++)
                System.out.print(arr[0][i] + " ");
            for(int i = 1; i < R; i++)
                System.out.print(arr[i][C - 1] + " ");
            for(int i = C - 2; i >= 0; i--)
                System.out.print(arr[R - 1][i] + " ");
            for(int i = R - 2; i >= 1; i--)
                System.out.print(arr[i][0] + " ");
        }
    }
}
