package Arrays;

import java.util.Scanner;

public class RearrangeArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        rearrange(arr, n);
    }

    static void rearrange(int[] arr, int n) {
        int l = 0;
        int r = n-1;
        int max = arr[r] + 1;

        for (int i=0; i<n; i++) {
            if ((arr[i] & 1) != 0) {
                arr[i] = (arr[r--] % max) * max + arr[i];
            } else {
                arr[i] = (arr[l++] % max) * max + arr[i];
            }
        }

        for (int i=0; i<n; i++) {
            arr[i] /= max;
            System.out.print(arr[i] + " ");
        }

    }
}
