package String;

public class SmallestWindowInAString {
    public static void main(String[] args) {
        String s = "timetopractice";
        String p = "toc";

        System.out.println(smallestWindow(s, p));
    }

    static String smallestWindow(String s, String p) {

        int n = s.length();
        int m = p.length();

        int count = 0;
        int len = Integer.MAX_VALUE;

        int start = 0;

        int[] freq = new int[256];

        for (int i=0; i<m; i++) {
            if (freq[p.charAt(i)] == 0) {
                count++;
            }

            freq[p.charAt(i)]++;
        }

        int i = 0;
        int j = 0;

        while (j < n) {
            freq[s.charAt(j)]--;

            if (freq[s.charAt(j)] == 0) {
                count--;
            }

            if (count == 0) {
                while (count == 0) {
                    if (len > j-i+1) {
                        len = Math.min(len, j-i+1);
                        start = i;
                    }

                    freq[s.charAt(i)]++;

                    if (freq[s.charAt(i)] > 0)
                        count++;

                    i++;
                }
            }
            j++;
        }
        if (len != Integer.MAX_VALUE)
            return s.substring(start, len+start);
        else
            return "-1";
    }
}
