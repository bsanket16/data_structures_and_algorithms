package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Left_Rotate_Arrays_By_K_Places {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Array before: " + Arrays.toString(arr));
        leftRotateArray(arr, n, k % n);
        System.out.println("Array After: " + Arrays.toString(arr));
    }

    static void leftRotateArray(int[] arr, int n, int k) {
        reverse(0, k-1, arr);
        reverse(k, n-1, arr);
        reverse(0, n-1, arr);
    }

    static void reverse(int s, int e, int[] arr) {
        while (s < e) {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++; e--;
        }
    }
}
