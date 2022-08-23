package String;

public class LexicographicRankOfString {
    public static void main(String[] args) {
        String str = "STRING";
        System.out.println(stringRank(str));
        System.out.println(stringRankOptimized(str));
    }

    private static int stringRankOptimized(String str) {
        int res = 1;
        int n = str.length();

        //calc fact
        int mul = fact(n);

        int[] count = new int[256];

        //frequencies
        for (int i=0; i<n; i++)
            count[str.charAt(i)]++;

        //cumulative sum
        for (int i=1; i<256; i++)
            count[i] += count[i-1];

        //final calc
        for (int i=0; i<n-1; i++) {
            mul = mul / (n-i);
            res = res + count[str.charAt(i)-1] * mul;

            for (int j = str.charAt(i); j<256; j++)
                count[j]--;
        }

        return res;
    }

    static int fact(int n) {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }

    static int stringRank(String str) {
        int n = str.length();
        int rank = 0;

        int i;
        for (i=0; i<n; i++) {
            int count = 0;
            for (int j=i+1; j<n; j++) {
                if (str.charAt(i) > str.charAt(j))
                    count++;
            }

            rank += doMath(count, n-i-1);
        }
        return rank+1;
    }

    static int doMath(int count, int f) {
        int fact = 1;

        for (int i=f; i>1; i--)
            fact *= i;

        return count * fact;
    }
}
