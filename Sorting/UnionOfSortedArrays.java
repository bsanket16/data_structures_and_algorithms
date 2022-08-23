package Sorting;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int[] a = {2, 20, 20, 40, 60};
        int[] b = {10, 20, 20, 20};

        printUnion(a, b);
    }

    static void printUnion(int[] a, int[] b) {
        int i=0, j=0;

        while (i<a.length && j<b.length) {
            if (i>0 && a[i] == a[i-1]) {
                i++;
                continue;
            }
            if (j>0 && b[j] == b[j-1]) {
                j++;
                continue;
            }
            if (a[i] == b[j]) {
                System.out.print(a[i] + " ");
                i++; j++;
            }
            else if (a[i] < b[j]) {
                System.out.print(a[i] + " ");
                i++;
            }
            else {
                System.out.print(b[j] + " ");
                j++;
            }
        }

        while (i< a.length) {
            if (i>0 && a[i] == a[i-1]) {
                i++;
                continue;
            }

            System.out.print(a[i] + " ");
            i++;
        }

        while (j<b.length) {
            if (j>0 && b[j] == b[j-1]) {
                j++;
                continue;
            }

            System.out.print(b[j] + " ");
            j++;
        }
    }
}
