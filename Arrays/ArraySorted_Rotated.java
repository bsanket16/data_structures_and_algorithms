package Arrays;

import java.util.Scanner;

public class ArraySorted_Rotated {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(checkArray(arr, n));
    }

    static boolean isIncreasing(int[] arr, int l, int r) {
        for (int i=l+1; i<=r; i++) {
            if (arr[i] < arr[i-1]) return false;
        }
        return true;
    }

    static boolean isDecreasing(int[] arr, int l, int r) {
        for (int i=l+1; i<=r; i++) {
            if (arr[i] > arr[i-1]) return false;
        }
        return true;
    }

    static boolean checkArray(int[] arr, int n) {
        int maxIndex = 0;
        int minIndex = 0;
        boolean res = false;

        for (int i=1; i<n; i++) {
            if (arr[i] > arr[maxIndex]) maxIndex = i;
            if (arr[i] < arr[minIndex]) minIndex = i;
        }

        if (maxIndex == minIndex-1) {
            if (arr[n-1] > arr[0]) return false;
            res =  isIncreasing(arr, 0, maxIndex) && isIncreasing(arr, minIndex, n-1);
        }
        if (minIndex == maxIndex-1) {
            if (arr[n-1] < arr[0]) return false;
            res =  isDecreasing(arr, 0, minIndex) && isDecreasing(arr, maxIndex, n-1);
        }

        return res;
    }
}
