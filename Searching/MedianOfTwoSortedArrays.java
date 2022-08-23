package Searching;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = {10, 20, 30, 40, 50};
        int[] B = {5, 15, 25, 35, 45};

        System.out.println(getMedian(A, B));
    }

    static double getMedian(int[] a, int[] b) {
        int start=0, end=a.length;

        while (start<=end) {
            int cut1 = start + (end-start) / 2;
            int cut2 = ((a.length + b.length + 1) / 2) - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2-1];
            int r1 = cut1 == a.length ? Integer.MAX_VALUE : a[cut1];
            int r2 = cut2 == b.length ? Integer.MAX_VALUE : b[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((a.length + b.length) % 2 == 0) {
                    return ((Math.max(l1, l2)) + (Math.min(r1, r2))) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
            else if (l1 > r2) {
                end = cut1 - 1;
            }
            else {
                start = cut1 + 1;
            }
        }
        return 0.0;
    }
}
