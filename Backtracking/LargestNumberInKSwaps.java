package Backtracking;

public class LargestNumberInKSwaps {
    public static void main(String[] args) {
        String str = "3435335";
        int k = 3;

        System.out.println(getLargestNumber(str, k));
    }

    private static String getLargestNumber(String str, int k) {

        String largest = str;


        for (int i=0; i<k; i++){

            int max = Math.max(Integer.parseInt(largest), Integer.parseInt(maxSwap(largest)));
            largest = String.valueOf(max);
        }

        return largest;
    }

    static String maxSwap(String str) {

        String largest = str;
        for (int i=0; i<str.length(); i++) {

            int max = Math.max(Integer.parseInt(largest), Integer.parseInt(swap(i, str)));
            largest = String.valueOf(max);
        }

        return largest;
    }

    static String swap (int x, String str) {

        String largest = str;

        for (int i=0; i<str.length(); i++) {

            StringBuilder og = new StringBuilder(str);

            char temp = og.charAt(i);
            og.setCharAt(i, og.charAt(x));
            og.setCharAt(x, temp);

            int max = Math.max(Integer.parseInt(largest), Integer.parseInt(String.valueOf(og)));
            largest = String.valueOf(max);
        }

        return largest;
    }
}
