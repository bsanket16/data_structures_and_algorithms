package DyanmicProgramming;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};
        int W = 4, N = 3;

        System.out.println(unboundedKnapsack(values, weight, W, N));
    }

    static int unboundedKnapsack(int[] values, int[] weight, int w, int n) {

        if (n == 0 || w == 0) return 0;

        if (weight[n-1] > w) {
            return unboundedKnapsack(values, weight, w, n-1);
        }

        else {
            return Math.max(values[n-1] + unboundedKnapsack(values, weight, w - weight[n-1], n), unboundedKnapsack(values, weight, w, n-1));
        }
    }
}
