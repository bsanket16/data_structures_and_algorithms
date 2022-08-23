package Arrays;

import java.util.Scanner;

public class Stock_Profits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] price = new int[n];
        for (int i=0; i<n; i++) {
            price[i] = in.nextInt();
        }

        System.out.println(maxProfit(price, 0, n-1));
    }

    static int maxProfit(int[] price, int start, int end) {
        if (end <= start) return 0;
        int profit = 0;

        for (int i = start; i < end; i++) {
            for (int j = i+1; j <= end; j++) {
                if (price[j] > price[i]) {
                    int curr_profit = price[j] - price[i] + maxProfit(price, start, i-1) + maxProfit(price, j+1, end);
                    profit = Math.max(profit, curr_profit);
                }
            }
        }

        return profit;
    }
}
