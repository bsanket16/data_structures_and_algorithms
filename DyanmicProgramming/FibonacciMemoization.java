package DyanmicProgramming;

import java.util.Arrays;

public class FibonacciMemoization {
    public static void main(String[] args) {
        int n = 9;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(getFib(n, memo));
    }

    private static int getFib(int n, int[] memo) {

        if (memo[n] == -1) {

            int res;
            if (n == 0 || n == 1) res = n;
            else {
                res = getFib(n-1, memo) + getFib(n-2, memo);
            }

            memo[n] = res;
        }

        return memo[n];
    }
}
