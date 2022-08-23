package Hashing;

import java.util.HashMap;

public class LongestCommonSpanWithTheSameSumInBinaryArray {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 0, 0, 0};
        int[] b = {1, 0, 1, 0, 0, 1};

        System.out.println(getLongestSpan(a, b));
        System.out.println(getLongestSpanOptimized(a, b));
    }

    static int getLongestSpanOptimized(int[] a, int[] b) {
        int[] temp = new int[a.length];

        for (int i=0; i<a.length; i++) {
            temp[i] = a[i] - b[i];
        }

        HashMap<Integer, Integer> hm = new HashMap<>();

        int ps = 0, len = 0;

        for (int i=0; i<a.length; i++) {
            ps += temp[i];
            if (ps == 0) len = Math.max(len, i+1);

            if (hm.containsKey(ps)) {
                len = Math.max(len, i-hm.get(ps));
            } else {
                hm.put(ps, i);
            }
        }
        return len;
    }

    static int getLongestSpan(int[] a, int[] b) {
        int len = 0;

        for (int i=0; i<a.length; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j=i; j<a.length; j++) {
                sum1 += a[j];
                sum2 += b[j];

                if (sum1 == sum2) {
                    len = Math.max(len, j-i+1);
                }
            }
        }

        return len;
    }
}
