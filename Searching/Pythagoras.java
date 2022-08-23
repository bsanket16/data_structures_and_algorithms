package Searching;

public class Pythagoras {
    public static void main(String[] args) {
        int[] A = {6, 8, 10, 12, 14, 16, 20};

        System.out.println(findPythagoras(A));
    }

    static boolean findPythagoras(int[] A) {
        for (int j : A) {
            int cSq = j * j;
            if (check(A, cSq)) return true;
        }
        return false;
    }

    static boolean check(int[] A, int x) {
        int l=0, r=A.length-1;
        while (l < r) {
            if ((A[l] * A[l]) + (A[r] * A[r]) == x) return true;
            else if ((A[l] * A[l]) + (A[r] * A[r]) > x) r--;
            else l++;
        }
        return false;
    }
}
