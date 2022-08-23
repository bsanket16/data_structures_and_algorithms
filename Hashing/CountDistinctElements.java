package Hashing;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {
        Integer[] arr = {10, 20, 10, 20, 30};
        System.out.println(distinctElement(arr));
    }

    static int distinctElement(Integer[] arr) {
        HashSet<Integer> mp = new HashSet<>(Arrays.asList(arr));
        return mp.size();
    }
}
