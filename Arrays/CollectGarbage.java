package Arrays;

import java.util.HashMap;
import java.util.Scanner;

public class CollectGarbage {
    public static void main(String[] args) {

        String[] garbage = {"MMM","PGM","GP"};
        int[] travel = {3,10};

        System.out.println(garbageCollection(garbage, travel));
    }

    private static int garbageCollection(String[] garbage, int[] travel) {

        // last seen index
        int mt = -1, gt = -1, pt = -1;
        Scanner sc = new Scanner(System.in);

        HashMap<Character, Integer> hm;

        for (int i=0; i<garbage.length; i++) {

            hm = new HashMap<>();
            for (int s=0; s<garbage[i].length(); s++) {

                hm.put(garbage[i].charAt(s), hm.getOrDefault(garbage[i].charAt(s), 0) + 1);

                if (hm.containsKey('M')) mt = i;
                if (hm.containsKey('G')) gt = i;
                if (hm.containsKey('P')) pt = i;
            }
        }

        int m = 0, p = 0, g = 0;

        for (int i=0; i<garbage.length; i++) {

            hm = new HashMap<>();
            for (int s=0; s<garbage[i].length(); s++) {
                hm.put(garbage[i].charAt(s), hm.getOrDefault(garbage[i].charAt(s), 0) + 1);
            }

            if (mt >= 0) {

                if (i==0) {
                    m+= hm.getOrDefault('M', 0);
                }
                else {
                    m+= hm.containsKey('M') ? hm.get('M') + travel[i-1]  : travel[i-1];
                }

                mt--;
            }

            if (gt >= 0) {

                if (i==0) {
                    g+= hm.getOrDefault('G', 0);
                }
                else {
                    g+= hm.containsKey('G') ? hm.get('G') + travel[i-1]  : travel[i-1];
                }

                gt--;
            }

            if (pt >= 0) {

                if (i==0) {
                    p+= hm.getOrDefault('P', 0);
                }
                else {
                    p+= hm.containsKey('P') ? hm.get('P') + travel[i-1] : travel[i-1];
                }

                pt--;
            }
        }

        return m + p + g;
    }
}
