package String;

public class BinaryString {
    public static void main(String[] args) {
        String str = "0101011101";
        System.out.println(getCountOptimized(str));
    }

    static int getCount(String str) {
        int count = 0;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '1') {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == '1') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static int getCountOptimized(String str) {
        int n = str.length();

        int c = 0;
        int tc = 0;
        int mx = 0;

        for (int i=0; i<n; i++)
            if (str.charAt(i) == '1') tc++;

        for (int i=0; i<n; i++) {
            if (str.charAt(i) == '1')  {
                c++;
                mx += tc - c;
            }
        }

        return mx;
    }
}
