package Arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class StockBuySell {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(stockTrading(arr, n));
    }

    static ArrayList<ArrayList<Integer>> stockTrading(int[] A, int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i=1; i<n; i++) {
            if (A[i] > A[i-1]) {
                ArrayList<Integer> stocks = new ArrayList<>();
                stocks.add(i-1);
                i++;

                while (i<n) {
                    if (A[i] >= A[i-1]) i++;
                    else break;
                }

                stocks.add(i-1);
                list.add(stocks);
            }
        }

        return list;
    }
}
