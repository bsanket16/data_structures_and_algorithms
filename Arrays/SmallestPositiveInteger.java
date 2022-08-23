package Arrays;

import java.util.Scanner;

public class SmallestPositiveInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(getSmallestNumber(arr, n));

//        int x = 1;
//
//        while (true) {
//            boolean f = false;
//            for (int i=0; i<n; i++) {
//                if (x == arr[i]) {
//                    f = true;
//                    break;
//                }
//            }
//            if (!f) {
//                System.out.println(x);
//                break;
//            }
//            x++;
//        }

//        int[] list = new int[1000001];
//        for (int i = 0; i < 1000001; i++) {
//            list[i] = 0;
//        }
//
//        for (int i=0; i<n; i++) {
//            if (arr[i] >= 0) {
//                list[arr[i]] = 1;
//            }
//        }
//
//        for (int i=1; i<1000001; i++) {
//            if (list[i] == 0) {
//                System.out.println(i);
//                break;
//            }
//        }
    }

//    3 1 4 5

    static int getSmallestNumber(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            if (arr[i] == i+1) {
                i++;
            } else {
                if ((arr[i] - 1) < n && arr[i] > 0) {
                    if (arr[arr[i]-1] != arr[i]) {
                        int temp = arr[arr[i]-1];
                        arr[arr[i]-1] = arr[i];
                        arr[i] = temp;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }
        }

        int x = 0;
        while (x < n) {
            if ((x+1) != arr[x]) {
                break;
            } else {
                x++;
            }
        }

        return x+1;
    }
}
