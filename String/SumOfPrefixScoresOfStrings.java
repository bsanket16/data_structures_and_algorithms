package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SumOfPrefixScoresOfStrings {
    public static void main(String[] args) {

        String[] words = {"abc","ab","bc","b"};
        System.out.println(Arrays.toString(sumPrefixScores(words)));
    }

    private static int[] sumPrefixScores(String[] words) {

        int[] res = new int[words.length];
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        int index = 0;

        for (String str : words) {

            ArrayList<String> temp = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {

                temp.add(str.substring(0, j + 1));
                hm.put(str.substring(0, j + 1), hm.getOrDefault(str.substring(0, j + 1), 0) + 1);
            }

            list.add(temp);
        }

        for (ArrayList<String> strings : list) {

            int sum = 0;

            for (String string : strings) {

                System.out.println(string);

                sum += hm.get(string);
            }

            res[index++] = sum;
            System.out.println();
        }



        return res;
    }
}
