package Hashing;

import java.util.HashSet;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 13, 3, -1};
        int sum = 22;
        System.out.println(findSubArr(arr, sum));
    }

    static boolean findSubArr(int[] arr, int sum) {
        HashSet<Integer> hs = new HashSet<>();

        int curr = 0;

        for (int i=0; i<arr.length; i++) {
            curr += arr[i];
            if (curr == sum) return true;
            if (hs.contains(curr - sum)){
                return true;
            }
            hs.add(curr);
        }
        return false;
    }
}
