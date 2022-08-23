package String;

import java.util.HashSet;

public class PAnagramChecking {
    public static void main(String[] args) {
        String str = "bawds jog, flick quartz, vex nymph";
        System.out.println(checkPangram(str));
    }

    public static boolean checkPangram  (String str) {
        int[] mp = new int[256];

        for (int i=0; i<str.length(); i++)
            mp[str.charAt(i)]++;

        for (int i=0; i<26; i++) {
            if ((mp['A' + i] == 0) || (mp['a' + i] == 0)) {
                return false;
            }
        }

        return true;
    }
}
