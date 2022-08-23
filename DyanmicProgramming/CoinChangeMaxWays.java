package DyanmicProgramming;

public class CoinChangeMaxWays {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;

        System.out.println(coinChangeI(coins, sum, coins.length));
    }

    private static int coinChangeI(int[] coins, int sum, int n) {

        int[][] dp = new int[n+1][sum+1];

        for (int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }

        for (int j=1; j<=sum; j++) {
            dp[0][j] = 0;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=sum; j++) {

                if (coins[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }

                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j - coins[i-1]];
                }
            }
        }

        return dp[n][sum];
    } 
}
