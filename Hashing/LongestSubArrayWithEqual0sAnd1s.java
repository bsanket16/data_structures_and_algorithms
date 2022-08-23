package Hashing;

import java.util.HashMap;

public class LongestSubArrayWithEqual0sAnd1s {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1, 0, 0};
        System.out.println(findLongestSubArray(arr));
        System.out.println(findLongestSubArrayOptimized(arr));
    }

    static int findLongestSubArrayOptimized(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) arr[i] = -1;
        }

        int ps = 0, len = 0;

        for (int i=0; i<arr.length; i++) {
            ps += arr[i];
            if (ps == 0) len = Math.max(len, i+1);

            if (hm.containsKey(ps)) {
                len = Math.max(len, i-hm.get(ps));
            } else {
                hm.put(ps, i);
            }
        }
        return len;
    }

    static int findLongestSubArray(int[] arr) {
        int len = 0;

        for (int i=0; i<arr.length; i++) {
            int cnt0 = 0, cnt1 = 0;
            for (int j=i; j<arr.length; j++) {
                if (arr[j] == 1) cnt1++;
                else cnt0++;
                if (cnt0 == cnt1) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
}
