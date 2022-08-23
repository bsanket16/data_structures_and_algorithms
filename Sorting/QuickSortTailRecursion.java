package Sorting;

import java.util.Arrays;

public class QuickSortTailRecursion {
    public static void main(String[] args) {
        int[] arr = {57, 38, 91, 10, 38, 28, 79, 41};
        int l = 0, h = arr.length-1;

        System.out.println(Arrays.toString(quickSort(arr, l, h)));
    }

    static int[] quickSort(int[] arr, int l, int h) {
        while (l < h) {
            int p = HoarePartition(arr, l, h);

            if (p-l < h-p) {
                quickSort(arr, l, p-1);
                l = p + 1;
            } else {
                quickSort(arr, p+1, h);
                h = p - 1;
            }
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
