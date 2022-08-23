package Arrays;

import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        int[] ps = buildPrefixSum(arr, n);

        getSum(ps, 0, 2);
        getSum(ps, 1, 3);
        getSum(ps, 2, 6);
    }

    static void getSum(int[] ps, int l, int r) {
        if (l != 0) {
            System.out.println((ps[r] - ps[l-1]));
        } else {
            System.out.println(ps[r]);
        }
    }

    static int[] buildPrefixSum(int[] arr, int n) {
        int[] prefix_sum = new int[n];
        prefix_sum[0] = arr[0];

        for (int i=1; i<n; i++) {
            prefix_sum[i] = arr[i] + prefix_sum[i-1];
        }

        return prefix_sum;
    }
}
