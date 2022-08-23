package String;

public class NaivePatternSearching {
    public static void main(String[] args) {
        String text = "ABCABCD";
        String pattern = "ABCD";

        System.out.println(patternSearch(text, pattern));
    }

    static int patternSearch(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        for (int i=0; i<=n-m; i++) {
            int j;
            for (j=0; j<m; j++)
                if (pat.charAt(j) != txt.charAt(i+j)) break;

            if (j == m) return i;
        }

        return -1;
    }
}
