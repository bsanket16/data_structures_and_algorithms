package Matrix;

import java.util.ArrayList;

public class SumOfTriangles {
    public static void main(String[] args) {
        int[][] arr = {
                {6, 5, 4},
                {1, 2, 5},
                {7, 9, 7}
        };

        System.out.println(sumTriangles(arr, arr.length));
    }

    static ArrayList<Integer> sumTriangles(int m[][], int n)
    {
        ArrayList<Integer> al = new ArrayList<>();

        int l = 0, r = 0;
        int sum1 = 0, sum2 = 0;

        for (int i=0; i<n; i++) {
            int j = 0;
            while (j<=l) {
                sum1 += m[i][j];
                j++;
            }
            l++;
        }

        for (int i=0; i<n; i++) {
            int j = n-1;
            while (j>=r) {
                sum2 += m[i][j];
                j--;
            }
            r++;
        }

        al.add(sum1);
        al.add(sum2);

        return al;

    }
}
