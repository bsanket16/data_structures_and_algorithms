package Sorting;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, 10, 7};
        int l = 0, h = arr.length-1, k = 2;

        int index = getSmallest(arr, l, h, k);

        System.out.println(arr[index]);
    }

    static int getSmallest(int[] arr, int l, int h, int k) {
        while(l<=h) {
            int p = lomutoPartition(arr, l, h);

            if (p == k-1) return p;
            else if (p > k-1) {
                h = p - 1;
            }
            else {
                l = p + 1;
            }
        }
        return -1;
    }

    static int lomutoPartition(int[] arr, int l, int h) {
        int p = arr[h];
        int i = l - 1;

        for (int j=l; j<= h - 1; j++) {
            if (arr[j] <= p) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[h];
        arr[h] = temp;

        return i+1;
    }
}
