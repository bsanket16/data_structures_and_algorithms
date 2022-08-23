package String;

public class AnagramSearch {
    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pattern = "sgrofs";

//        System.out.println(searchAnagram(text, pattern));
        System.out.println(searchAnagramOptimized(text, pattern));
    }


//    loop all possible windows and then pass to anagram function
    static boolean searchAnagram(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        for (int i=0; i<=n-m; i++) {
            for (int j=0; j<m; j++) {
                boolean flag = false;
                for (int k=i; k<i+m; k++) {
                    if (txt.charAt(k) == pat.charAt(j)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) break;
                else if (j == m - 1) return true;
            }
        }
        return false;
    }

    static boolean searchAnagramOptimized(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        int t = 0, p = 0;

        for (int i=0; i<m; i++) {
            t = t + txt.charAt(i);
            p = p + pat.charAt(i);
        }

        for (int i=0; i<=n-m; i++) {
            if (t == p) return true;
            else {
                if (i < n-m) {
                    t = t - txt.charAt(i) + txt.charAt(i+m);
                }
            }
        }

        return false;
    }
}
