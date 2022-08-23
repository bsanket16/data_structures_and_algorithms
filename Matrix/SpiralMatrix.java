package Matrix;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        spiralMatrix(arr);
    }

    static void spiralMatrix(int[][] arr) {
        int R = arr.length, C = arr[R-1].length;
        int start = 0;

        while (R-1>0 && C > 0) {
            spiral(arr, start, R, C);
            start++;
            R--;
            C--;
        }
    }

    static void spiral(int[][] arr, int start, int r, int c) {
        for (int i=start; i<c; i++) {
            System.out.print(arr[start][i] + " ");
        }

        for (int i=start+1; i<r; i++) {
            System.out.print(arr[i][c-1] + " ");
        }

        for (int i=c-2; i>=start; i--) {
            System.out.print(arr[r-1][i] + " ");
        }

        for (int i=r-2; i>=start+1; i--) {
            System.out.print(arr[i][start] + " ");
        }

    }
}
