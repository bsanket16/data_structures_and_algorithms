package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {

        String str = "aabb";

        List<List<String>> subStringsList = new ArrayList<>();
        partition(0, str, new ArrayList<>(), subStringsList);

        System.out.println(subStringsList);
    }

    public static void partition(int index, String str, List<String> ds, List<List<String>> list) {

        if (index == str.length()) {
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int i=index; i<str.length(); i++){

            if (isPalindrome(str.substring(index, i+1))) {

                ds.add(str.substring(index, i+1));
                partition(i+1, str, ds, list);
                ds.remove(ds.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str) {

        if (str.length() == 1) return true;

        int l = 0, h = str.length()-1;

        while (l < h) {
            if (str.charAt(l) != str.charAt(h)) return false;
            l++; h--;
        }

        return true;
    }
}
