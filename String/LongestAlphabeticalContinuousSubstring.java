package String;

public class LongestAlphabeticalContinuousSubstring {
    public static void main(String[] args) {

        String s = "abcdsde";
        System.out.println(longestContinuousSubstring(s));
    }

    public static int longestContinuousSubstring(String s) {

        int length = 1, count = 1;

        for (int i=1; i<s.length(); i++) {
            System.out.println((int)s.charAt(i));


            if ((int)s.charAt(i) == (int)s.charAt(i-1)+1) {

                count++;
                length = Math.max(length, count);
            }
            else {

                count = 1;
            }
        }

        return length;

    }
}
