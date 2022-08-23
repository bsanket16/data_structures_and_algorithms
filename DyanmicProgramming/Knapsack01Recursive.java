package DyanmicProgramming;

public class Knapsack01Recursive {
    public static void main(String[] args) {

        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};
        int W = 4, N = 3;

        System.out.println(knapsackRec(W, weight, values, N));
    }

    static int knapsackRec(int w, int[] weight, int[] values, int n) {

        if (n == 0 || w == 0) return 0;

        if (weight[n-1] > w) {
            return knapsackRec(w, weight, values, n-1);
        }
        else {
            return Math.max(knapsackRec(w, weight, values, n-1), values[n-1] + knapsackRec(w - weight[n-1], weight, values, n-1));
        }
    }
}
