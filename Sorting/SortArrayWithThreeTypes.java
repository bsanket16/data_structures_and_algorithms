package Sorting;

import java.util.Arrays;

public class SortArrayWithThreeTypes {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 1, 0, 0, 2, 1, 2};

        System.out.println(Arrays.toString(sortArrays(arr)));
    }

    static int[] sortArrays(int[] arr) {
        int l = 0, m = 0, h = arr.length-1;

        while(m<=h) {
            switch (arr[m]) {
                case 0:
                    int temp = arr[l];
                    arr[l] = arr[m];
                    arr[m] = temp;
                    l++;
                    m++;
                    break;

                case 1:
                    m++;
                    break;

                case 2:
                    int prev = arr[h];
                    arr[h] = arr[m];
                    arr[m] = prev;
                    h--;
                    break;
            }
        }
        return arr;
    }
}
