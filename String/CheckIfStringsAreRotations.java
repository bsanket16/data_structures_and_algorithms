package String;

import java.util.Objects;

public class CheckIfStringsAreRotations {
    public static void main(String[] args) {
        String s1 = "m";
        String s2 = "m  ";

        System.out.println(isRotated(s1, s2));
    }

    static boolean isRotated(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return ((s1+s1).indexOf(s2) > 0);
    }
}
