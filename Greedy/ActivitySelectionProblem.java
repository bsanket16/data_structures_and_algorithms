package Greedy;

import java.util.Arrays;

class Work implements Comparable<Work>
{
    int start, end;

    Work (int a, int b) {
        this.start = a;
        this.end = b;
    }

    public int compareTo(Work o) {
        return this.end - o.end;
    }
}
public class ActivitySelectionProblem
{
    public static void main(String[] args) {
        int[] start = {7, 2, 2, 3};
        int[] end = {8, 4, 7, 10};
        int n = 4;

        System.out.println(activitySelection(start, end, n));

    }

    public static int activitySelection(int[] start, int[] end, int n)
    {
        Work[] arr = new Work[n];

        int index = 0;
        for (int i=0; i<n; i++) {
            arr[index++] =  new Work(start[i], end[i]);
        }

        Arrays.sort(arr);

        int res = 1, prev = 0;

        for (int i=1; i<n; i++) {
            if (arr[i].start > arr[prev].end) {
                res++;
                prev = i;
            }
        }

        return res;
    }
}
