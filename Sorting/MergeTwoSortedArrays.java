package Sorting;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] a = {10, 15, 20, 20};
        int[] b = {1, 12};

        mergeArrays(a, b);
    }

    static void mergeArrays(int[] a, int[] b) {
        int i=0, j=0;

        while (i<a.length && j<b.length) {
            if (a[i] <= b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else {
                System.out.print(b[j] + " ");
                j++;
            }
        }

        while (i<a.length) {
            System.out.print(a[i] + " ");
            i++;
        }

        while (j<b.length) {
            System.out.print(b[j] + " ");
            j++;
        }
    }
}
