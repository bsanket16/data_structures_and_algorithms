package Arrays;

import java.util.Scanner;

public class MaxSubArraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }
//        System.out.println(calMaxSum(arr, n));

        System.out.println(calMaxSumOptimized(arr, n));
    }

    static int calMaxSum(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int max_so_far;

        for (int i=0; i<n; i++) {
            max_so_far = 0;
            for (int j=i; j<n; j++) {
                max_so_far += arr[j];
                max = Math.max(max, max_so_far);
            }
        }
        return max;
    }

    static int calMaxSumOptimized (int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int max_so_far = 0;

        for (int i=0; i<n; i++) {
            max_so_far += arr[i];
            if (max_so_far > max) {
                max = max_so_far;
            }
            if (max_so_far < 0) {
                max_so_far = 0;
            }
        }

        return max;
    }
}
