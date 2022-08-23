package String;

import java.util.Arrays;

public class ReverseWordsInAGivenString {
    public static void main(String[] args) {
        String S = "i.like.this.program.very.much";
        System.out.println(reverseWords(S));
    }

    static String reverseWords(String S)
    {
        StringBuilder str = new StringBuilder(S);
        str.reverse();
        char[] ch = str.toString().toCharArray();

        int start = 0;
        for (int i=0; i<ch.length; i++) {
            if (ch[i] == '.' || i==ch.length-1) {
                int l = start, h= i == ch.length-1 ? i : i-1;
                while (l<h) {
                    char t = ch[l];
                    ch[l] = ch[h];
                    ch[h] = t;
                    l++;
                    h--;
                }
                start = i+1;
            }
        }
        return new String(ch);
    }
}
