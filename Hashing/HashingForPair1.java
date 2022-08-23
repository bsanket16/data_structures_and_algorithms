package Hashing;

import java.util.HashSet;

public class HashingForPair1 {
    public static void main(String[] args) {
        int[] arr= {61, 14, 75, 71, 36, 34, 12};
        int sum = 68;

        System.out.println(sumExists(arr, sum));
    }

    static int sumExists(int[] arr, int sum) {
        HashSet<Integer> hs = new HashSet<>();

        for (int x : arr) hs.add(x);

        for (int i=0; i<arr.length; i++) {
            if (hs.contains(sum - arr[i])) {
                return 1;
            }
        }
        return 0;
    }
}
