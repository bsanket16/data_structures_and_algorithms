package String;

import java.util.HashMap;

public class RemoveCommonCharactersAndConcatenate {
    public static void main(String[] args) {
        String s1 = "aabcd";
        String s2 = "adke";

        System.out.println(concatenatedString(s1, s2));
    }

    public static String concatenatedString(String s1,String s2) {
        int n = s1.length();
        int m = s2.length();

        HashMap<Character, Integer> mp = new HashMap<>();

        for (int i=0; i<m; i++)
            mp.put(s2.charAt(i), 1);

        StringBuilder res = new StringBuilder();

        for (int i=0; i<n; i++) {
            if (!mp.containsKey(s1.charAt(i))) {
                res.append(s1.charAt(i));
            } else {
                mp.put(s1.charAt(i), 2);
            }
        }

        for (int i=0; i<m; i++) {
            if (mp.get(s2.charAt(i)) == 1) {
                res.append(s2.charAt(i));
            }
        }

        return res.length() == 0 ? "-1" : res.toString();
    }
}
