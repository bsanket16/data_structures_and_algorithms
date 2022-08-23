package Arrays;

import java.util.ArrayList;
import java.util.List;

public class SunOfInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 9};

        List<List<Long>> queries = new ArrayList<>();

        List<Long> l1 = new ArrayList<>();
        l1.add(1L);
        l1.add(5L);

        List<Long> l2 = new ArrayList<>();
        l2.add(10L);
        l2.add(13L);

        List<Long> l3 = new ArrayList<>();
        l3.add(7L);
        l3.add(11L);

        queries.add(l1);
        queries.add(l2);
        queries.add(l3);

        System.out.println(sumInRangesNaive(arr, arr.length, queries, queries.size()));
        System.out.println(sumInRanges(arr, arr.length, queries, queries.size()));
    }

    public static List<Integer> sumInRangesNaive(int[] arr, int n, List<List<Long>> queries, int q) {
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<q; i++) {
            int sum = 0;

            for (Long j=queries.get(i).get(0); j<=queries.get(i).get(1); j++) {
                int index = (int)(j-1) % n;
                sum += arr[index];
            }

            list.add(sum);
        }

        return list;
    }

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {
        List<Integer> list = new ArrayList<>();

        int[] ps = new int[n+1];

        ps[0] = 0;

        for (int i=1; i<=n; i++) {
            ps[i] = ps[i-1] + arr[i-1];
        }

        for (int i=0; i<q; i++) {
            Long L = queries.get(i).get(0);
            Long R = queries.get(i).get(1);

            Long left = ((((L-1) / n) * ps[n]) % 1000000007 + (ps[(int)((L-1) % n)]) % 1000000007) % 1000000007;
            Long right = (((R / n) * ps[n]) % 1000000007 + (ps[(int)(R % n)]) % 1000000007) % 1000000007;
            list.add((int)(right - left));
        }

        return list;
    }
}
