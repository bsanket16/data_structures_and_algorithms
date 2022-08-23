package Arrays;

import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.print(getMajority(arr, n));
    }

    static int getMajority(int[] arr, int n) {
        int res = 0, count = 1;
        for (int i = 1; i<n; i++) {
            if (arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }

            if (count==0) {
                res = i;
                count = 1;
            }
        }

        count = 0;
        for (int i=0; i<n; i++) {
            if (arr[res] == arr[i]) {
                count++;
            }
        }

        if (count <= n/2) {
            return -1;
        }

        System.out.print("Majority Element: " + arr[res] + " Index: ");

        return res;
    }
}
