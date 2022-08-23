package Arrays;

import java.util.Scanner;

public class DivideIn3Parts {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//        int n = in.nextInt();
//        int[] arr = new int[n];
//
//        for (int i=0; i<n; i++) {
//            arr[i] = in.nextInt();
//        }
//
//        System.out.println(canDivide(arr, n));

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        System.out.println(arr.length);
    }

    static boolean canDivide(int[] arr, int n) {
        int sum = 0;

        for (int i=0; i<n; i++)
            sum += arr[i];

        if (sum % 3 == 0) {
            int finder = 0;
            boolean first = false, second = false;

            for (int i=0; i<n; i++) {
                finder += arr[i];
                if ((finder == (sum / 3)) && !first) first = true;
                else if (finder == ((sum / 3) * 2)) second = true;
                if (first && second) break;
            }

            return first && second;
        }

        return false;
    }
}
