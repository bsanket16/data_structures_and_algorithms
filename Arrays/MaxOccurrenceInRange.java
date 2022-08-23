package Arrays;

import java.util.ArrayList;

public class MaxOccurrenceInRange {
    public static void main(String[] args) {
        int[] l = {1, 2, 3};
        int[] r = {3, 5, 7};
        int n = 3;

        System.out.println(maxOccurrenceValue(l, r, n));
    }

    static int maxOccurrenceValue(int[] l, int[] r, int n) {
        int[] arr = new int[1000];

        for (int i=0; i<n; i++) {
            arr[l[i]]++;
            arr[r[i]+1]--;
        }

        int max = arr[0], res = 0;
        for (int i=1; i<1000; i++) {
            arr[i] += arr[i-1];
            if (arr[i] > max) {
                max = arr[i];
                res = i;
            }
        }

        return res;
    }
}
