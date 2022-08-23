package Matrix;

import java.util.Arrays;

public class AddingTwoMatrices {
    public static void main(String[] args) {
        int[][] a = {{1, 2},
                {3, 4},
                {5, 6}};

        int[][] b = {{1, 3},
                {3, 2},
                {3, 3}};

        for (int[] arr : addMatrix(a, b)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    static int[][] addMatrix(int[][] a, int[][] b) {
        System.out.println(a.length + " " + a[0].length);

        int[][] arr = new int[a.length][a[0].length];

        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[0].length; j++) {
                arr[i][j] = a[i][j] + b[i][j];
            }
        }

        return arr;
    }
}
