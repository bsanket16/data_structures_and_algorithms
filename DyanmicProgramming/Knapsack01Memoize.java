package DyanmicProgramming;

import java.util.Arrays;

public class Knapsack01Memoize {

    public static void main(String[] args) {

        int[] values = {1, 3, 2, 4};
        int[] weight = {1, 2, 3, 4};
        int W = 7, N = 4;

        int[][] t = new int[101][101];
        Arrays.stream(t).forEach(a -> Arrays.fill(a, -1));

        System.out.println(knapsackRec(W, weight, values, N, t));
    }

    static int knapsackRec(int w, int[] weight, int[] values, int n, int[][] t) {

        if (n == 0 || w == 0) return 0;

        if (t[n][w] != -1) return t[n][w];

        if (weight[n-1] > w) {
            return t[n][w] = knapsackRec(w, weight, values, n-1, t);
        }
        else {
            return t[n][w] = Math.max(knapsackRec(w, weight, values, n-1, t), values[n-1] + knapsackRec(w - weight[n-1], weight, values, n-1, t));
        }
    }
}