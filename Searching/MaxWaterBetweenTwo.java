package Searching;

public class MaxWaterBetweenTwo {
    public static void main(String[] args) {
        int[] arr= {2,1,3,4,6,5};
        int n = 6;

        System.out.println(getMax(arr, n));
    }

    static int getMax(int[] arr, int n) {
        if (n==0 || n==1 || n==2) {
            return 0;
        }
        int i = 0;
        int j = n-1;
        int aux;
        int res = 0;

        while (i<=j) {
            aux = Math.min(arr[i], arr[j]) * (j - i - 1);
            if (arr[i] < arr[j]) {
                i++;
            } else {
                j--;
            }
            res = Math.max(res, aux);
        }

        return res;
    }
}
