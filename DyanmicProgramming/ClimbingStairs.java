package DyanmicProgramming;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {

        int n = 5;

        // recursive
        System.out.println(getUniqueRecursive(n));

        // memoized
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(getUniqueMemoized(n, dp));

        // tabulation
        int[] t = new int[n+1];
        System.out.println(getUniqueTabulation(n, t));

    }

    private static int getUniqueRecursive(int n) {

        if (n < 0) return 0;
        if (n == 0) return 1;

        int left = getUniqueRecursive(n-1);
        int right = getUniqueRecursive(n-2);

        return left + right;
    }

    private static int getUniqueMemoized(int n, int[] dp) {

        if (n < 0) return 0;
        if (n == 0) return 1;

        if (dp[n] != -1) return dp[n];
        else return dp[n] = getUniqueMemoized(n-1, dp) + getUniqueMemoized(n-2, dp);
    }

    private static int getUniqueTabulation(int n, int[] t) {

        t[1] = 1; t[2] = 2;
        for (int i=3; i<=n; i++) {
            t[i] = t[i-1] + t[i-2];
        }
        return t[n];
    }
}
