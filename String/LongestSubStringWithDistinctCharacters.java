package String;

public class LongestSubStringWithDistinctCharacters {
    public static void main(String[] args) {
        String str = "abaacdbab";
        System.out.println(getLength(str));
        System.out.println(getLengthOptimized(str));
    }

    private static int getLength(String str) {
        if (str.length() <= 1) return str.length();
        int n = str.length();
        int res = 1;

        for (int i=0; i<n; i++) {
            int count = 1;
            for (int j=i+1; j<n; j++) {
                boolean flag = true;

                for (int k=j-1; k>=i; k--) {
                    if (str.charAt(j) == str.charAt(k)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    count++;
                    res = Math.max(res, count);
                } else break;
            }
        }
        return res;
    }

    static int getLengthOptimized(String str) {
        int n = str.length();
        int[] cnt = new int[300];
        int mx = 1;

        cnt[str.charAt(0)]++;
        int i = 0, j = 0;

        while (j != n-1) {
            if (cnt[str.charAt(j+1)] == 0) {
                j++;
                cnt[str.charAt(j)] = 1;
                mx = Math.max(mx, j-i+1);
            } else {
                cnt[str.charAt(i)]--;
                i++;
            }
        }

        return mx;
    }
}
