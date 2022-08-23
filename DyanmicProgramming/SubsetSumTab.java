package DyanmicProgramming;

public class SubsetSumTab {
    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 8, 10};
        int sum = 11;
        int n = arr.length;

        System.out.println(isSubsetSum(arr, n, sum));
    }

    private static int isSubsetSum(int[] arr, int n, int sum) {

        int[][] dp = new int[n+1][sum+1];

        for (int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }

        for (int j=1; j<=sum; j++) {
            dp[0][j] = 0;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {

                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }

                else {
                    // OR operator
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}
