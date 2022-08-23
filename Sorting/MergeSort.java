package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 15, 21, 20, 4, 3};
        int l = 0;
        int r = arr.length-1;
        mergeSort(arr, l, r);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (r > l) {
            int m = l + (r-l) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] left = new int[m-l+1];
        int[] right = new int[r-m];

        for (int x=0; x<left.length; x++) left[x] = arr[x + l];

        for (int x=0; x<right.length; x++) right[x] = arr[m+1+x];

        int i = 0, j = 0, k = l;

        while (i<left.length && j<right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i<left.length)
            arr[k++] = left[i++];

        while (j<right.length)
            arr[k++] = right[j++];

    }
}
