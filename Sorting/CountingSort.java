package Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 7, 5, 2};
        int k = 8;

        countSort(arr, k);

        System.out.println(Arrays.toString(arr));
    }

    static void countSort(int[] arr, int k) {
        int[] count = new int[k];

        for (int i=0; i<k; i++)
            count[i] = 0;

        for (int j : arr) count[j]++;

        for (int i=1; i<k; i++)
            count[i] += count[i-1];

        int[] output = new int[arr.length];

        for (int i = arr.length-1; i>=0; i--) {
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
