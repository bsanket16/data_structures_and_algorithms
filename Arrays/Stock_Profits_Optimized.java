package Arrays;

import java.util.Scanner;

public class Stock_Profits_Optimized {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] price = new int[n];
        for (int i=0; i<n; i++) {
            price[i] = in.nextInt();
        }

        System.out.println(maxProfit(price, n));
    }

    static int maxProfit(int[] price, int n) {
        int profit = 0;
        for (int i=1; i<n; i++) {
            if (price[i] > price[i-1]) {
                profit += price[i] - price[i-1];
            }
        }
        return profit;
    }
}
