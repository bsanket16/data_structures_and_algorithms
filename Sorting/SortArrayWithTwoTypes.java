package Sorting;

import java.util.Arrays;

public class SortArrayWithTwoTypes {
    public static void main(String[] args) {
        int[] arr = {15, 14, 13, 12};
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    static int[] sortArray(int[] arr) {
        int i = -1;

        for (int j=0; j<arr.length; j++) {
            if (arr[j] % 2 == 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return arr;
    }
}
