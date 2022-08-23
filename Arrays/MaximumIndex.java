package Arrays;

import java.util.Scanner;

public class MaximumIndex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

//        System.out.println(getMaxIndex(arr, n));
        System.out.println(getMaxIndexOptimized(arr, n));
    }

    static int getMaxIndexOptimized(int[] arr, int n) {
        int[] rmax = new int[n];
        rmax[n-1] = arr[n-1];

        for (int i=n-2; i>=0; i--)
            rmax[i] = Math.max(arr[i], rmax[i+1]);

        int diff = Integer.MIN_VALUE;
        int i=0, j=0;

        while (i<n && j<n) {
            if (rmax[j] >= arr[i]) {
                diff = Math.max(diff, j-i);
                j++;
            } else {
                i++;
            }
        }

        return diff;
    }

    static int getMaxIndex(int[] arr, int n) {
        int diff = -1;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (arr[i] <= arr[j]) {
                    diff = Math.max(diff, j - i);
                }
            }
        }
        return diff;
    }
}
