package String;

import java.util.Arrays;

public class KeypadTyping {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        int[] ch = new int[26];

        int count = 2;

        for(int i=0; i<24; i = i+3) {

            ch[i] = count;
            ch[i+1] = count;
            ch[i+2] = count;
            if (i==15) {
                ch[i+3] = count;
                i++;
            }
            if (i==22) {
                ch[i+3] = count;
            }
            count++;
        }

//        System.out.println(Arrays.toString(ch));

        StringBuilder q = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            q.append(ch[s.charAt(i) - 'a']);
        }

        System.out.println(q);
    }
}
