package Sorting;

import java.util.Arrays;

public class HoaresPartition {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 10, 7};
        int l = 0, h = arr.length-1;

        System.out.println(Arrays.toString(hoaresPartition(arr, l, h)));
    }

    static int[] hoaresPartition(int[] arr, int l, int h) {
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

            if (i >= j) return arr;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
