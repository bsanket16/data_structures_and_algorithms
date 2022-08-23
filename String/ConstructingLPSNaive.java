package String;

import java.util.Arrays;

public class ConstructingLPSNaive {
    public static void main(String[] args) {
        String str = "ababacab";
        int[] lps = new int[str.length()];

        System.out.println(Arrays.toString(constructLPS(str, lps)));
        System.out.println(Arrays.toString(lpsOptimized(str, lps)));
    }

    private static int[] constructLPS(String str, int[] lps) {
        for (int i=0; i<str.length(); i++) {
            lps[i] = getLPS(str, i+1);
        }
        return lps;
    }

    static int getLPS(String str, int n) {
        for (int len = n-1; len > 0; len--) {
            boolean flag = true;
            for (int i=0; i<len; i++) {
                if (str.charAt(i) != str.charAt(n - len + i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return len;
        }
        return 0;
    }

    static int[] lpsOptimized(String str, int[] lps) {
        int n = str.length();
        int len = 0;
        lps[0] = 0;

        int i=1;

        while (i<n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                }
                else {
                    len = lps[len-1];
                }
            }
        }

        return lps;
    }
}
