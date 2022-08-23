package Hashing;

import java.util.*;

public class SortTheArrayAccordingToOther {
    public static void main(String[] args) {
        int[] A = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] B = {99, 22, 444, 56, 2, 2};

        System.out.println(Arrays.toString(customSort(A, B)));
    }

    static int[] customSort(int[] A, int[] B) {
        int[] op = new int[A.length];

        LinkedHashSet<Integer> Bs = new LinkedHashSet<>();

//        removed duplicates
        for (int k : B) Bs.add(k);


//      store freq of A[]
        SortedMap<Integer, Integer> lhs = new TreeMap<>();

        for (int j : A) {
            lhs.put(j, lhs.getOrDefault(j, 0) + 1);
        }


//      loop Bs[] and put elem into the op[]
        int index = 0;
        for (int x : Bs) {
            if (lhs.get(x) != null) {
                int insert = lhs.get(x);
                while (insert != 0) {
                    op[index] = x;
                    index++;
                    insert--;
                }
                lhs.remove(x);
            }
        }

//      get remaining elements from the lhs[]
        for (Map.Entry<Integer, Integer> entry : lhs.entrySet()) {
            int insert = entry.getValue();
            while (insert != 0) {
                op[index++] = entry.getKey();
                insert--;
            }
        }

        return op;
    }
}
