package Sorting;

import java.util.Arrays;

public class OuickSortLomuto {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, 10, 7};
        int l = 0, h = arr.length-1;

        System.out.println(Arrays.toString(quickSort(arr, l, h)));
    }

    static int[] quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int p = lomutoPartition(arr, l, h);
            quickSort(arr, l, p-1);
            quickSort(arr, p+1, h);
        }
        return arr;
    }

    static int lomutoPartition(int[] arr, int l, int h) {
        int p = arr[h];
        int i = l - 1;

        for (int j=l; j<= h - 1; j++) {
            if (arr[j] <= p) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;

        return i+1;
    }
}
