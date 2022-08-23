package Arrays;

import java.util.Scanner;

public class MaxLengthEvenOddSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(calMaxLengthEvenOddSubArray(arr, n));
    }

    static int calMaxLengthEvenOddSubArray(int[] arr, int n) {
        int max_so_far = 1, res = 1;

        for (int i=1; i<n; i++) {
            if (((arr[i] & 1) == 0 && (arr[i-1] & 1) == 0) || ((arr[i] & 1) != 0 && (arr[i-1] & 1) != 0)) {
                max_so_far = 1;
            } else {
                max_so_far++;
                res = Math.max(res, max_so_far);
            }
        }
        return res;
    }
}
