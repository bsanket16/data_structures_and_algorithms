package Arrays;

import java.util.Scanner;

public class SearchSumInSubArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int sum = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(searchForSum(arr, n, sum));
    }

    static boolean searchForSum(int[] arr, int n, int sum) {
        int start = 0;
        int res = arr[0];

        for (int end=1; end<n; end++) {
//            cleanup
            while (res > sum && start < end - 1) {
                res -= arr[start];
                start++;
            }
            if (res == sum) return true;
            res += arr[end];
        }
        return (res == sum);
    }
}
