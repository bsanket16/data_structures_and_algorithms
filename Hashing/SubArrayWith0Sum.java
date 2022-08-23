package Hashing;

import java.util.HashSet;

public class SubArrayWith0Sum {
    public static void main(String[] args) {
        int[] arr = {-3, 4, -3, -1, 1};
        System.out.println(findSubArray(arr));
    }

    static boolean findSubArray(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int sum = 0;
        for (int j : arr) {
            sum += j;

            if (sum == 0 || hs.contains(sum)) return true;
            else hs.add(sum);
        }
        return false;
    }
}
