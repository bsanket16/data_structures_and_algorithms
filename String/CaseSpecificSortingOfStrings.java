package String;

public class CaseSpecificSortingOfStrings {
    public static void main(String[] args) {
        String str = "defRTSersUXI";
        System.out.println(sortString(str));
    }

    static String sortString(String str) {
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];

        for (int i=0; i<str.length(); i++) {
            if ((str.charAt(i) - 'a') >= 0) {
                ch1[str.charAt(i) - 'a']++;
            } else {
                ch2[str.charAt(i) - 'A']++;
            }
        }

        StringBuilder s = new StringBuilder();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (int i=0; i<26; i++) {
            if (ch1[i] > 0) {
                int len1 = ch1[i];
                while (len1 > 0) {
                    str1.append((char)('a' + i));
                    len1--;
                }
            }

            if (ch2[i] > 0) {
                int len2 = ch2[i];
                while (len2 > 0) {
                    str2.append((char)('A' + i));
                    len2--;
                }
            }
        }

        int s1 = 0, s2 = 0;

        for (int i=0; i<str.length(); i++) {
            if ((str.charAt(i) - 'a') >= 0) {
                s.append(str1.charAt(s1));
                s1++;
            } else {
                s.append(str2.charAt(s2));
                s2++;
            }
        }

        return s.toString();
    }
}
