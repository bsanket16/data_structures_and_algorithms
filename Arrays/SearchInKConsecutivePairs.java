package Arrays;

import java.util.Scanner;

public class SearchInKConsecutivePairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int sum = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(searchForSuminKPairs(arr,n, k, sum));
    }

    static boolean searchForSuminKPairs(int[] arr, int n, int k, int sum) {
        int curr_max = 0;
        for (int i=0; i<k; i++) {
            curr_max += arr[i];
        }

        if (curr_max == sum) return true;

        for (int j=k; j<n; j++) {
            curr_max += (arr[j] - arr[j-k]);
            if (curr_max == sum) return true;
        }

        return false;
    }
}
