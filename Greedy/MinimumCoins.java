package Greedy;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {10, 5, 2, 1};
        int cost = 57;

        System.out.println(minCoins(coins, cost));
    }

    private static int minCoins(int[] coins, int cost) {

        int res = 0;

        for (int coin : coins) {
            if (coin <= cost) {
                int c = cost / coin;
                cost = cost - c * coin;
                res += c;
            }

            if (cost == 0) break;
        }

        return res;
    }
}
