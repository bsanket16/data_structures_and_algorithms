package String;

public class StringIsSubsequenceOfOther {
    public static void main(String[] args) {
        String str1 = "string";
        String str2 = "str";

        int n = str1.length();
        int m = str2.length();

        System.out.println(isSubsequence(str1, str2));
        System.out.println(isSubsequenceRecursive(str1, str2, n, m));
    }

//    Iterative Method
    static boolean isSubsequence(String a, String b) {
        int  n = a.length(), m = b.length();
        int j = 0;

        for (int i=0; i<n && j<m; i++)
            if (a.charAt(i) == b.charAt(j)) j++;

        return j == m;
    }

//    Recursive Method
    static boolean isSubsequenceRecursive(String a, String b, int n, int m) {

        if (m==0) return true;
        if (n==0) return false;

        if (a.charAt(n-1) == b.charAt(m-1)) {
            return isSubsequenceRecursive(a, b, n-1, m-1);
        }
        else {
            return isSubsequenceRecursive(a, b, n-1, m);
        }
    }
}
