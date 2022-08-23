package String;

public class KMP {
    public static void main(String[] args) {
        String text = "abbabb";
        String pattern = "abb";

        kmpSearch(text, pattern);
    }

    static void kmpSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        constructLPS(pat, lps);

        int i = 0, j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++; j++;
            }
            if (j == m) {
                System.out.println(i-j);
                j = lps[j-1];
            }
            else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j == 0) i++;
                else j = lps[j-1];
            }
        }
    }

    static void constructLPS(String pat, int[] lps) {
        int n = pat.length();
        lps[0] = 0;
        int i = 1, len = 0;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                }
                else {
                    len = lps[len-1];
                }
            }
        }
    }
}
