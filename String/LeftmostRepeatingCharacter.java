package String;

public class LeftmostRepeatingCharacter {
    public static void main(String[] args) {
        String str = "abcd";
//        System.out.println(leftRepeatingChar(str));
//        System.out.println(leftRepeatingCharOptimized(str));
        System.out.println(leftRepeatingCharEfficient(str));
    }

    static int leftRepeatingChar(String str) {
        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            for (int j=i+1; j<str.length(); j++) {
                if (ch == str.charAt(j)) return i;
            }
        }

        return -1;
    }

    static int leftRepeatingCharOptimized(String str) {
        int[] ch = new int[256];

        for (int i=0; i<str.length(); i++) {
            ch[str.charAt(i)]++;
        }

        for (int i=0; i<str.length(); i++) {
            if (ch[str.charAt(i)] >= 2) return i;
        }

        return -1;
    }

    static int leftRepeatingCharEfficient(String str) {
        boolean[] ch = new boolean[256];

        int res = -1;

        for (int i=str.length()-1; i>=0; i--) {
            if (!ch[str.charAt(i)]) {
                res = i;
                ch[str.charAt(i)] = true;
            }
        }

        return res;
    }
}
