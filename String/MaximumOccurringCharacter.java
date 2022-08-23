package String;

public class MaximumOccurringCharacter {
    public static void main(String[] args) {
        String line = "aA";
        System.out.println(getChar(line));
    }

    static char getChar(String line) {
        int n = line.length();
        if (n==1) return line.charAt(0);

        int[] ch = new int[256];

        for (int i=0; i<n; i++) {
            ch[line.charAt(i)]++;
        }

        int mx = 0;

        for (int i=0; i<n; i++) {
            mx = Math.max(mx, ch[line.charAt(i)]);
        }

        int res = Integer.MAX_VALUE;

        for (int i=0; i<n; i++) {
            if (mx == ch[line.charAt(i)]) {
                res = Math.min(res, line.charAt(i));
            }
        }

        return (char) res;
    }
}
