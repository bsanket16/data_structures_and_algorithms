package Hashing;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesInArray {
    public static void main(String[] args) {
        int[] arr = {10, 12, 10, 15, 10, 20, 12, 12};
        getFreq(arr);
    }

    static void getFreq(int[] arr) {
        HashMap<Integer, Integer> mp = new HashMap<>();


        for (int j : arr) {
            mp.put(j, mp.getOrDefault(j, 0) + 1);
//            if (mp.containsKey(arr[i])) {
//                mp.put(arr[i], mp.get(arr[i]) + 1);
//            } else {
//                mp.put(arr[i], 1);
//            }
        }

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
