package Hashing;

import java.util.HashMap;

public class SubArrayRangeWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {0, 0, 5, 5, 0, 0};
//        10 12 10 -10 0
        int sum = 0;
        System.out.println(findSubArrays(arr, sum));
        System.out.println(findCountOfSubArrays(arr));
    }

    static int findSubArrays(int[] arr, int sum) {
        int count = 0, curr = 0;

        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                curr += arr[j];
                if (curr == sum) count++;
            }
            curr = 0;
        }

        return count;
    }

    static int findCountOfSubArrays(int[] arr) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        int ps = 0, count = 0;

        for (int i=0; i<arr.length; i++) {
            ps += arr[i];

            if (ps == 0) count++;

            if (hs.containsKey(ps)) {
               count += hs.get(ps);
            }

                hs.put(ps, hs.getOrDefault(ps, 0) + 1);
        }

        return count;
    }
}
