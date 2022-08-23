package Arrays;

import java.util.Scanner;

public class MinimumAdjacentDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(minDifference(arr, n));
    }

    static int minDifference(int[] arr, int n) {
        int res = Integer.MAX_VALUE;
        int minDiff;

        for (int i=0; i<n; i++) {
            if (i == n-1) {
                minDiff = arr[i] - arr[0];
            }
            else {
                minDiff = arr[i] - arr[i + 1];
            }
            res = Math.min(res, Math.abs(minDiff));
        }

        return res;
    }
}
