package Sorting;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 9, 10, 10, 2, 4 };
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void cycleSort(int[] arr) {
        int n = arr.length;
        int writes = 0;

        for (int cs=0; cs<n-1; cs++) {
            int item = arr[cs];
            int pos = cs;

            for (int i = cs + 1; i < n; i++)
                if (arr[i] < item)
                    pos++;

            if (pos == cs) continue;

            while (item == arr[pos]) {
                pos+=1;
            }

            if (pos != cs) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }

            while (pos != cs) {
                pos = cs;
                for (int i = cs + 1; i < n; i++)
                    if (arr[i] < item)
                        pos++;

                while (item == arr[pos]) {
                    pos+=1;
                }

                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
        }
        System.out.println("writes : " + writes);
    }
}
