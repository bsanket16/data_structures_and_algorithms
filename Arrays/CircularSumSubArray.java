package Arrays;

import java.util.Scanner;

public class CircularSumSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

//        System.out.println(getCircularSum(arr, n));
        System.out.println(getCircularSumOptimized(arr, n));
    }

    static int getCircularSum(int[] arr, int n) {
        int res = 0, max_so_far;

        for (int i=0; i<n; i++) {
            max_so_far = arr[i];
            res = Math.max(max_so_far, res);
            for (int j=1; j<n; j++) {
                int index = (i+j) % n;
                max_so_far += arr[index];
                res = Math.max(max_so_far, res);
            }
        }
        return res;
    }

    static int getCircularSumOptimized(int[] arr, int n) {
        int cRes = arr[0], cMin = arr[0], nRes = arr[0], nMax = arr[0], sum = arr[0];

        for (int i=1; i<n; i++) {
            nMax = Math.max(nMax + arr[i], arr[i]);
            nRes = Math.max(nMax, nRes);
            cMin = Math.min(cMin + arr[i], arr[i]);
            cRes = Math.min(cMin, cRes);
            sum += arr[i];
        }

        return nRes < 0 ? nRes : Math.max(nRes, sum-cRes);
    }
}
