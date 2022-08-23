package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordSubsets {
    public static void main(String[] args) {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"l","e"};

        System.out.println(wordSubsets(words1, words2));
    }
    
    public static List<String> wordSubsets(String[] words1, String[] words2) {

        List<String> list = new ArrayList<>();

        HashMap<Character, Integer> hm;

        for (String s1 : words1) {

            hm = new HashMap<>();

            for (char ch : s1.toCharArray()) hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            boolean flag = true;

            for (String s2 : words2) {

                HashMap<Character, Integer> temp = new HashMap<>(hm);
                boolean flag2 = true;

                for (char ch : s2.toCharArray()) {

                    if (!temp.containsKey(ch) || temp.get(ch) == 0) {
                        flag2 = false;
                        break;
                    } else {
                        temp.put(ch, temp.get(ch) - 1);
                    }

                }

                if (!flag2) {
                    flag = false;
                    break;
                }
            }

            if (flag) list.add(s1);

        }

        return list;
    }
}
