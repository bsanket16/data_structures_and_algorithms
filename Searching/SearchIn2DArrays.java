package Searching;

import java.util.Arrays;

public class SearchIn2DArrays {
    public static void main(String[] args) {
        int[][] arr = {
                {12, 54, 98, 37},
                {45, 68},
                {5, 45, 89, 32},
                {35, 84, 6}
        };

        int target = 89;
        System.out.println(searchTarget(arr, target));
        System.out.println(Arrays.toString(searchTargetIndex(arr, target)));
    }

    static int[] searchTargetIndex(int[][] arr, int target) {
        for (int row=0; row<arr.length; row++) {
            for (int col=0; col<arr[row].length; col++) {
                if (arr[row][col] == target) return new int[]{row,col};
            }
        }
        return new int[]{-1, -1};
    }

    static boolean searchTarget(int[][] arr, int target) {
        for (int row=0; row<arr.length; row++) {
            for (int col=0; col<arr[row].length; col++) {
                if ((arr[row][col] & 1) == 0) return true;
            }
        }
        return false;
    }
}
