package DyanmicProgramming;

import java.util.Arrays;

public class FibonacciProblem {
    public static void main(String[] args) {

        int n = 6;

        // recursion
        System.out.println(getFibRecursion(n));

        // memoization
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(getFibMemoized(n, dp));

        // tabulation
        int[] t = new int[n+1];
        t[0] = 0; t[1] = 1;
        System.out.println(getFibTabulation(n, t));

        // space optimized
        System.out.println(getFibSpaceOptimized(n));
    }

    private static int getFibRecursion(int n) {
        if (n <= 1) return n;
        return getFibRecursion(n-1) + getFibRecursion(n-2);
    }

    private static int getFibMemoized(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        else return dp[n] = getFibMemoized(n-1, dp) + getFibMemoized(n-2, dp);
    }

    private static int getFibTabulation(int n, int[] t) {
        for (int i=2; i<=n; i++) {
            t[i] = t[i-1] + t[i-2];
        }
        return t[n];
    }

    private static int getFibSpaceOptimized(int n) {
        int first = 1, second = 0, fib = 0;
        for (int i=2; i<=n; i++) {
            fib = first + second;
            second = first;
            first = fib;
        }
        return fib;
    }

}
