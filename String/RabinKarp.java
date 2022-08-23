package String;

public class RabinKarp {
    static final int q = 101;
    static final int d = 256;

    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pattern = "eks";

        int n = text.length();
        int m = pattern.length();

        RBSearch(text, pattern, n, m);
    }

    static void RBSearch(String txt, String pat, int n, int m) {

        // calc pow(d, m-1) % q
        int h = 1;
        for (int i=1; i<=m-1; i++)
            h = (h * d) % q;

        // calc hash for t and p
        int t = 0, p = 0;

        for (int i=0; i<m; i++) {
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }

        // slide all the possible windows in txt
        for (int i=0; i<=n-m; i++) {
            if (t == p) {
                boolean flag = true;
                for (int j=0; j<m; j++)
                    if (pat.charAt(j) != txt.charAt(i+j)) {
                        flag = false;
                        break;
                    }

                if (flag) System.out.println(i + " ");
            }

            if (i < n-m) {
                t = ((d * (t - txt.charAt(i) * h)) + txt.charAt(i + m)) % q;

                if (t < 0) t = t+q;
            }
        }
    }
}
