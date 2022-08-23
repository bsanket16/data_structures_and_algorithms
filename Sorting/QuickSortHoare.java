package Sorting;

import java.util.Arrays;

public class QuickSortHoare {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, 10, 7};
        int l = 0, h = arr.length-1;

        System.out.println(Arrays.toString(quickSort(arr, l, h)));
    }

    static int[] quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int p = HoarePartition(arr, l, h);
            quickSort(arr, l, p);
            quickSort(arr, p+1, h);
        }
        return arr;
    }

    static int HoarePartition(int[] arr, int l, int h) {
        int pivot = arr[l];

        int i = l - 1;
        int j = h + 1;

        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i >= j) return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
