package String;

public class CheckForAnagram {
    public static void main(String[] args) {
        String str1 = "silent";
        String str2 = "listen";

        System.out.println(isAnagram(str1, str2));
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        int[] ch = new int[256];

        for (int i = 0; i<a.length(); i++) {
            ch[a.charAt(i)] += 1;
            ch[b.charAt(i)] -= 1;
        }

        for (int i=0; i<26; i++) {
            if (ch[i] != 0) return false;
        }
        return true;
    }
}
