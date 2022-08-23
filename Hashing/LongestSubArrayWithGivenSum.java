package Hashing;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 0, 1, 8, 2, 3, 6};
//        1 2 3 3 3
        int sum = 5;

//        System.out.println(longestSubArray(arr, sum));
        System.out.println(longestSubArrayOptimized(arr, sum));
    }

    static int longestSubArray(int[] arr, int sum) {
        int len = 0;
        for (int i=0; i<arr.length; i++) {
            int curr = 0;
            for (int j=i; j<arr.length; j++) {
                curr += arr[j];
                if (curr == sum) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }

    static int longestSubArrayOptimized(int[] arr, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int len = 0, curr = 0;

        for (int i=0; i<arr.length; i++) {
            curr += arr[i];
            if (curr == sum) return i+1;
            if (hm.containsKey(curr-sum)) {
                len = Math.max(len, i-hm.get(curr-sum));
            }
            if (!hm.containsKey(curr)) {
                hm.put(curr, i);
            }
        }

        return len;
    }
}
