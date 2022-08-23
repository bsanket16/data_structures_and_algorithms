package Arrays;

import java.util.Scanner;

public class Max_Difference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getMaxDifference(arr, n));
    }

    static int getMaxDifference(int[] arr, int n) {
        if (arr.length < 2) return -1;
        int res = arr[1] - arr[0], minVal = arr[0];

        for (int j=1; j<n; j++) {
            res = Math.max(res, arr[j] - minVal);
            minVal = Math.max(minVal, arr[j]);
        }
        return res;
    }
}
