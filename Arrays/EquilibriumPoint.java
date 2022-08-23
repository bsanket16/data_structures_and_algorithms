package Arrays;

import java.util.Scanner;

public class EquilibriumPoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

//        System.out.println(isEquilibrium(arr, n));
//        System.out.println(isEquilibriumOptimized(arr, n));
        System.out.println(isEquilibriumOptimizedPro(arr, n));
    }

    static boolean isEquilibrium(int[] arr, int n) {

        for (int i=0; i<n; i++) {
            int lSum = 0;
            for (int l=0; l<i; l++) {
                lSum += arr[l];
            }

            int rSum = 0;
            for (int r=i+1; r<n; r++) {
                rSum += arr[r];
            }

            if (lSum == rSum) return true;
        }
        return false;
    }

    static boolean isEquilibriumOptimized(int[] arr, int n) {
        int[] ps = new int[n];
        ps[0] = arr[0];

        for (int i=1; i<n; i++) {
            ps[i] = arr[i] + ps[i-1];
        }

        for (int e=0; e<n; e++) {
            int lMax, rMax;
            rMax = ps[n-1] - ps[e];

            if (e != 0) {
                lMax = ps[e-1];
            } else {
                lMax = 0;
            }

            if (lMax == rMax) return true;
        }
        return false;
    }

    static boolean isEquilibriumOptimizedPro(int[] arr, int n) {
        int sum = arr[0];
        for (int i=1; i<n; i++)
            sum += arr[i];

        int leftSum = 0;
        for (int i=0; i<n; i++) {
            if (leftSum == sum - arr[i]) return true;
            leftSum += arr[i];
            sum -= arr[i];
        }
        return false;
    }
}
