package Sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 15, 50, 4, 20};
        int n = arr.length;
        heapSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void heapSort(int[] arr, int n) {
        // build heap
        buildHeap(arr, n);

        for (int i=n-1; i>=1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void buildHeap(int[] arr, int n) {
        for (int i=(n/2)-1; i>=0; i--) {
            heapify(arr, n, i);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int largest = i, left = (2*i+1), right = (2*i+2);

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, largest);
        }
    }
}
