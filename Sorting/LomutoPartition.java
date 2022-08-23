package Sorting;

import java.util.Arrays;

public class LomutoPartition {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, 10, 7};
        int l = 0, h = arr.length-1;

        System.out.println(Arrays.toString(lomutoPartition(arr, l, h)));
    }

    static int[] lomutoPartition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;

        for (int j=l; j<= h - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;

        return arr;
    }
}
