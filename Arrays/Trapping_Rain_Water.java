package Arrays;

import java.util.Scanner;

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] pole = new int[n];
        for (int i=0; i<n; i++) {
            pole[i] = in.nextInt();
        }

        System.out.println(trapRainWater(pole, n));
    }

//    static int trapRainWaters(int[] pole, int n) {
//        if (n < 3) return 0;
//        int capacity = 0;
//        int start, end;
//
//        for (int i=0; i<n-1; i++) {
//            start=i;
//            while (start <= n-2) {
//                if (pole[start] > pole[start + 1]) {
//                    break;
//                } else {
//                    start++;
//                }
//            }
//            end = start + 1;
//            for (int j=end+1; j<n; j++) {
//                if (pole[j] > pole[end]) {
//                    end = j;
//                }
//                if (j == n-1) break;
////                if (pole[j] > pole[j+1]) break;
//                i = j;
//            }
//
//            int x = Math.min(pole[start], pole[end]);
//            for (int k = start+1; k<end; k++) {
//                    capacity += x - pole[k];
//            }
//        }
//        return capacity;
//    }

    static int trapRainWater(int[] pole, int n) {
        int capacity = 0;
        for (int i=1; i<n-1; i++) {
            int lmax = pole[i];
            for (int j=0; j<i; j++) {
                lmax = Math.max(lmax, pole[j]);
            }
            int rmax = pole[i];
            for (int k=i+1; k<n; k++) {
                rmax = Math.max(rmax, pole[k]);
            }
            capacity += Math.min(lmax, rmax) - pole[i];
        }
        return capacity;
    }
}

