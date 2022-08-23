package Arrays;

import java.util.Scanner;

public class MaxKConsecutiveSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

//        System.out.println(getMaxSum(arr, n, k));
        System.out.println(getMaxSumOptimized(arr, n, k));
    }

    static int getMaxSum(int[] arr, int n, int k) {
        int res = Integer.MIN_VALUE, curr_max;

        for (int i=0; i+k-1<n; i++) {
            curr_max = 0;
            for (int j=i; j<i+k; j++) {
                curr_max += arr[j];
            }
            res = Math.max(curr_max, res);
        }

        return res;
    }

    static int getMaxSumOptimized(int[] arr, int n, int k) {
        int res, curr_max = 0;

        for (int i=0; i<k; i++) {
            curr_max += arr[i];
        }

        res = curr_max;

        for (int j=k; j<n; j++) {
            curr_max += (arr[j] - arr[j-k]);
            res = Math.max(res, curr_max);
        }

        return res;
    }
}
