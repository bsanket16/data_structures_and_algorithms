package String;

public class Palindrome {
    public static void main(String[] args) {
        String str = "malayalam";
        System.out.println(palindromeCheck(str));
    }

    private static boolean palindromeCheck(String str) {
        int left = 0, right = str.length()-1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}