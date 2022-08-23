package Sorting;


public class CountInversions {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int l = 0, r = arr.length-1;
        System.out.println(countInversions(arr, l, r));
    }

    static int countInversions(int[] arr, int l, int r) {
        int res = 0;
        if (r > l) {
            int m = l + (r-l) / 2;

            res += countInversions(arr, l, m);
            res += countInversions(arr, m+1, r);
            res += merge(arr, l, m, r);
        }
        return res;
    }

    static int merge(int[] arr, int l, int m, int r) {
        int[] left = new int[m-l+1];
        int[] right = new int[r-m];

        for (int x=0; x<left.length; x++)  left[x] = arr[l+x];
        for (int x=0; x<right.length; x++) right[x] = arr[m+1+x];

        int res = 0, i = 0 ,j = 0, k = l;

        while (i<left.length && j<right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
                res += (left.length) - i;
            }
        }

        while (i<left.length) {
            arr[k++] = left[i++];
        }

        while (j<right.length) {
            arr[k++] = right[j++];
        }

        return res;
    }
}
