package Sorting;

import java.util.Arrays;

public class MergeWithoutExtraSpace {
    public static void main(String[] args) {
        int[] A = {1, 4, 7, 8, 10};
        int[] B = {2, 3, 9};

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));

        mergeArrays(A, B, A.length, B.length);

        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
    }

    static int nextGap(int gap) {
        if (gap<=1) return 0;
        return (gap / 2) + (gap % 2);
    }

    static void mergeArrays(int[] A, int[] B, int N, int M) {
        int i, j, gap = N+M;

        for (gap=nextGap(gap); gap>0; gap=nextGap(gap)) {
            for (i=0; i+gap<N; i++) {
                if (A[i] > A[i+gap]) {
                    int temp = A[i];
                    A[i] = A[i+gap];
                    A[i+gap] = temp;
                }
            }

            for (j=gap>N? gap - N : 0; i<N && j<M; i++, j++) {
                if (A[i] > B[j]) {
                    int temp = A[i];
                    A[i] = B[j];
                    B[j] = temp;
                }
            }

            if (j<M) {
                for (j=0; j+gap<M; j++) {
                    if (B[j] > B[j+gap]) {
                        int temp = B[j];
                        B[j] = B[j + gap];
                        B[j + gap] = temp;
                    }
                }
            }
        }

    }
}
