package Sorting;

public class NaivePartition {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 10, 7};
        int p = 5, l = 0, h = arr.length-1;

        System.out.println(naivePartition(arr, l, h, p));
    }

    static int naivePartition(int[] arr, int l, int h, int p) {
        int[] temp = new int[h-l+1];
        int index = 0;

        for (int i=l; i<=h; i++) if (arr[i] < arr[p]) temp[index++] = arr[i];

        for (int i=l; i<=h; i++) if (arr[i] == arr[p]) temp[index++] = arr[i];

        int res = l + (index - 1);

        for (int i=l; i<=h; i++) if (arr[i] > arr[p]) temp[index++] = arr[i];

        if (h + 1 - l >= 0) System.arraycopy(temp, 0, arr, l, h + 1 - l);

        return res;
    }
}
