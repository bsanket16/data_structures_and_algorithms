package Searching;

import java.util.ArrayList;

public class TwoRepeatedElements {
    public static void main(String[] args) {
        int[] arr = {4, 2, 4, 5, 2, 3, 1};
        int n = 5;

        System.out.println(findTwoOptimized(arr, n));
    }

    static ArrayList<Integer> findTwo(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        int i=0;

        while (i < n+2) {
            if (i+1 == arr[i]) {
                arr[i] = -1;
                i++;
            } else {
                if (arr[i] < 0) {
                    i++;
                    continue;
                }
                if (arr[arr[i]-1] < 0) {
                    if (arr[arr[i]-1] == -1) list.add(arr[i]);
                    arr[arr[i]-1]--;
                    i++;
                } else {
                    int temp = arr[arr[i]-1];
                    arr[arr[i]-1] = -1;
                    arr[i] = temp;
                }
            }
        }

        return list;
    }

    static ArrayList<Integer> findTwoOptimized (int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();

        int i=0;

        while (i < n+2) {
            int getAbs = Math.abs(arr[i]);

            if (arr[getAbs] < 0) {
                list.add(getAbs);
            } else {
                arr[getAbs] *= -1;
            }
            i++;
        }
        return list;
    }
}
