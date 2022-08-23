package Sorting;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeOverlappingIntervals {
    public static void mergeIntervals(Interval[] arr) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o.start));

        int index = 0;

        for (int i=1; i< arr.length; i++) {
            if (arr[index].end >= arr[i].start) {
                arr[index].end = Math.max(arr[index].end, arr[i].end);
                arr[index].start = Math.min(arr[index].start, arr[i].start);
            }
            else {
                index++;
                arr[index] = arr[i];
            }
        }

        for (int i = 0; i <= index; i++)
        {
            System.out.print("[" + arr[i].start + ","
                    + arr[i].end + "]");
        }
    }

    public static void main(String[] args) {
        Interval[] arr = new Interval[4];
        arr[0] = new Interval(1, 3);
        arr[1] = new Interval(2, 4);
        arr[2] = new Interval(5, 7);
        arr[3] = new Interval(6, 8);
        mergeIntervals(arr);
    }
}
