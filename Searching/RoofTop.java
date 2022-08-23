package Searching;

public class RoofTop {
    public static void main(String[] args) {
        int[] arr = {1,2,2,2,4,5};
        int n = arr.length;
        System.out.println(maxStep(arr, n));
    }

    static int maxStep(int A[], int N)
    {
        int steps=0, mx=0;
        for (int i=1; i<N; i++) {
            if (A[i] > A[i-1]) {
                mx++;
                steps = Math.max(steps, mx);
            } else {
                mx = 0;
            }
        }
        return steps;
    }
}
