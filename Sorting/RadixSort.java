package Sorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};

        radixSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void radixSort(int[] arr) {
        int mx = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }

        for (int exp=1; mx / exp > 0; exp *= 10) {
            countingSort(arr, arr.length, exp);
        }
    }

    static void countingSort(int[] arr, int n, int exp) {
        int[] count = new int[10];
        int[] output = new int[n];

        for (int i=0; i<n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        for (int i=1; i<10; i++) {
            count[i] += count[i-1];
        }

        for (int i = n-1; i>=0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
