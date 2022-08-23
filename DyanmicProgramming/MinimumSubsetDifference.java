package DyanmicProgramming;

public class MinimumSubsetDifference {
    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};
        int n = arr.length;

        System.out.println(miniDiff(arr, n));
    }

    private static int miniDiff(int[] arr, int n) {

        int sum = arr[0];
        for (int i=1; i<n; i++) {
            sum += arr[i];
        }

        boolean[][] dp = new boolean[n+1][sum+1];

        for (int i=0; i<=n; i++) {
            dp[i][0] = true;
        }

        for (int j=1; j<=sum; j++) {
            dp[0][j] = false;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum;  j++) {

                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }

                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]];
                }
            }
        }

        int res = 0;

        for (int j = sum / 2; j >= 0; j--) {

            if (dp[n][j]) {
                res = sum - 2 * j;
                break;
            }
        }

        return res;
    }
}
