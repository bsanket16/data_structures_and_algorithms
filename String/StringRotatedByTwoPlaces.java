package String;

import java.util.Objects;

public class StringRotatedByTwoPlaces {
    public static void main(String[] args) {
        String str1 = "amazon";
        String str2 = "azonam";

        System.out.println(checkRotation(str1, str2));
    }

    private static boolean checkRotation(String str1, String str2) {
            String f1 = str1.substring(0,2);
        String l1 = str1.substring(2);

        System.out.println(l1+f1);

        return Objects.equals(str2, l1 + f1);
    }
}
