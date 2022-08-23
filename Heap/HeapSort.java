package Heap;

import java.util.Arrays;

public class HeapSort {
    void heap(int[] arr, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heap(arr, n, largest);
        }
    }

    public void buildHeap(int[] arr,int n){
        for (int i = n / 2 - 1; i >= 0; i--)
            heap(arr, n, i);
    }

    public void sort(int[] arr)
    {
        int n = arr.length;

        buildHeap(arr,n);

        for (int i=n-1; i>0; i--)
        {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heap(arr, i, 0);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println(Arrays.toString(arr));

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        System.out.println(Arrays.toString(arr));
    }
}
