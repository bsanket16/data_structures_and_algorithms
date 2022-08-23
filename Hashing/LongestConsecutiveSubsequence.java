package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 3, 3, 2, 9, 10};
        System.out.println(findSubSequence(arr));
        System.out.println(findSubSequenceOptimized(arr));
    }

    static int findSubSequence(int[] arr) {
        Arrays.sort(arr);
        int len = 1;

        int curr = 1;

        for (int i=1; i<arr.length; i++) {
            if (arr[i]==arr[i-1]+1) {
                curr++;
            } else {
                len = Math.max(len, curr);
                curr = 1;
            }
        }

        len = Math.max(len, curr);
        return len;
    }

    static int findSubSequenceOptimized(int[] arr) {
        int len = 1;
        HashSet<Integer> hs = new HashSet<>();

        for (int j : arr)
            hs.add(j);

        for (int i : hs) {
            if (!hs.contains(i - 1)) {
                int curr = 1;
                while (hs.contains(i + curr)) {
                    curr += 1;
                }
                len = Math.max(len, curr);
            }
        }

        return len;

    }
}
