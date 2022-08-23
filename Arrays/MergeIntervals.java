package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},
                {2,6},
                {8, 10},
                {15,18}
        };

        int[][] newIntervals = merge(intervals);

        for (int[] i : newIntervals) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static int[][] merge(int[][] intervals) {

        LinkedList<int[]> res = new LinkedList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int[] interval : intervals) {

            if (res.size() == 0) res.add(interval);

            if (interval[0] <= res.peekLast()[1]) {
                res.peekLast()[1] = Math.max(interval[1], res.peekLast()[1]);
            }

            else {
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
