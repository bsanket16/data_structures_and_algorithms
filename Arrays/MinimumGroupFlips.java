package Arrays;

import java.util.Scanner;

public class MinimumGroupFlips {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

//        getFlips(arr, n);
        getFlipsOptimized(arr, n);
    }

    static void getFlips(int[] arr, int n) {
        int zeroFlips = 0, oneFlips = 0, x;

        if (arr[0] == 0) {
            zeroFlips++;
        } else {
            oneFlips++;
        }

        for (int i=1; i<n; i++) {
            switch (arr[i]) {
                case 0:
                    if (arr[i-1] != 0) zeroFlips++;
                    break;
                case 1:
                    if (arr[i-1] != 1) oneFlips++;
                    break;
            }
        }

        x = zeroFlips <= oneFlips ? 0 : 1;
        int start = -1, end = -1;

        for (int i=0; i<n; i++) {
            if (arr[i] == x && start == -1) {
                start = i;
            } else if (i != 0 && arr[i] != x && arr[i-1] == x && end == -1) {
                end = i-1;
                System.out.println("From " + start + " to " + end);
                start = -1;
                end = -1;
            }
        }

    }

    static void getFlipsOptimized(int[] arr, int n) {
        for (int i=1; i<n; i++) {
            if (arr[i] != arr[i-1]) {
                if (arr[i] != arr[0]) {
                    System.out.print("from " + i + " to ");
                } else {
                    System.out.print(i-1);
                    System.out.println();
                }
            }
        }
        if (arr[n-1] != arr[0]) System.out.print(n-1);
    }
}
