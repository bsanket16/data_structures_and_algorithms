package Sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = { 30, 40, 10, 80, 5, 12, 70};
        int k = 4;

        bucketSort(arr, k);

        System.out.println(Arrays.toString(arr));
    }

    static void bucketSort(int[] arr, int k) {
        int mx = arr[0];
        for (int i=1; i<arr.length; i++) {
            mx = Math.max(mx, arr[i]);
        }

        mx++;

        Vector<Integer>[] buckets = new Vector[arr.length];

        for (int i=0; i<arr.length; i++) {
            buckets[i] = new Vector<Integer>();
        }

        for (int j : arr) {
            int idx = (j * k) / mx;
            buckets[idx].add(j);
        }

        for (int i=0; i<arr.length; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;

        for (int i=0; i<k; i++) {
            for (int j=0; j<buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}
