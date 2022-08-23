package Hashing;

import java.util.HashSet;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {10, 20, 10, 30, 20};
        int[] b = {20, 10, 10, 40};

        getIntersection(a, b);
    }

    static void getIntersection(int[] a, int[] b) {
        HashSet<Integer> mp = new HashSet<>();

        for (int j : a) {
            mp.add(j);
        }

        for (int j : b) {
            if (mp.contains(j)) {
                System.out.println(j);
                mp.remove(j);
            }
        }
    }
}
