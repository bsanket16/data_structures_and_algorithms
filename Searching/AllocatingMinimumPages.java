package Searching;

public class AllocatingMinimumPages {
    public static void main(String[] args) {
        int[] A = {15, 17, 20 };
        int k = 2;

        System.out.println(minPages(A, k));
    }

    static int minPages(int[] A, int k) {
        int sum = 0, mx = 0;
        for (int j : A) {
            sum += j;
            mx = Math.max(mx, j);
        }

        int l = mx, r = sum, res = -1;
        while (l<=r) {
            int m = l + (r-l)/2;
            if (isValid(A, k, m)) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    static boolean isValid(int[] A, int k, int cap) {
        int student = 1, pages = 0;

        for (int j : A) {
            pages += j;
            if (pages > cap) {
                student++;
                pages = j;
            }
            if (student > k) {
                return false;
            }
        }
        return true;
    }
}
