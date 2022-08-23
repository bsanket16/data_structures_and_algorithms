package String;

import java.util.Arrays;

public class LeftmostNonRepeatingCharacter {
    public static void main(String[] args) {
        String S = "hello";
        System.out.println(nonRepeatingCharacter(S));
    }

    static char nonRepeatingCharacter(String S)
    {
        int[] ch = new int[256];
        Arrays.fill(ch, -1);

        for (int i=0; i<S.length(); i++) {
            if (ch[S.charAt(i)] == -1) {
                ch[S.charAt(i)] = i;
            } else {
                ch[S.charAt(i)] = -2;
            }
        }

        int res = Integer.MAX_VALUE;

        for (int i=0; i<256; i++) {
            if (ch[i] >= 0) {
                res = Math.min(res, ch[i]);
            }
        }

        return res == Integer.MAX_VALUE ? '$' : S.charAt(res);
    }
}
