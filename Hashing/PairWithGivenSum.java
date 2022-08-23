package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {3, 2, 8, 8, 8};
        int sum = 16;

        System.out.println(findPair(arr, sum));
    }

    static boolean findPair(int[] arr, int sum) {
        HashSet<Integer> hs = new HashSet<>();

        for (int j : arr) {
            if (hs.contains(sum - j)) {
                return true;
            } else {
                hs.add(j);
            }
        }

        return false;
    }
}
