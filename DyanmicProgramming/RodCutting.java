package DyanmicProgramming;

public class RodCutting {

    public static void main(String[] args) {

        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};
        int W = 4, N = 3;

        System.out.println(knapsackRec(W, weight, values, N));
    }

    static int knapsackRec(int w, int[] weight, int[] values, int n) {

        int[][] t = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {

                if (weight[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.max(values[i - 1] + t[i][j - weight[i - 1]], t[i - 1][j]);
                }
            }
        }

        return t[n][w];
    }
}
