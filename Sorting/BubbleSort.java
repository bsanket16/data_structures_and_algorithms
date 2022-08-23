package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 5, 3};
        bubbleSort(arr);
    }

    static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            boolean isSwapped = false;
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }

        System.out.println(Arrays.toString(arr));
    }
}
