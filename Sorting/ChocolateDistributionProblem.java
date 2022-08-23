package Sorting;

import java.util.Arrays;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int k = 5;

        System.out.println(getChocolates(arr, k));

    }

    static int getChocolates(int[] arr, int k) {
        if (k > arr.length) return -1;

        Arrays.sort(arr);
        int n = arr.length, res = arr[k-1] - arr[0];

        for (int i=1; (i+k-1) < n; i++) {
            int mx = arr[i+k-1]-arr[i];
            res = Math.min(res, mx);
        }

        return res;
    }
}
