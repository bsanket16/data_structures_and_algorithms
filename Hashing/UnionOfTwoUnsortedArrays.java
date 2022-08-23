package Hashing;

import java.util.HashSet;

public class UnionOfTwoUnsortedArrays {
    public static void main(String[] args) {
        int[] a = {15, 20, 5, 15};
        int[] b = {15, 15, 15, 20, 10};

        getUnion(a, b);
    }

    static void getUnion(int[] a, int[] b) {
        HashSet<Integer> mp = new HashSet<>();

        for (int i : a) mp.add(i);
        for (int i : b) mp.add(i);

        System.out.println(mp.size());
    }
}
