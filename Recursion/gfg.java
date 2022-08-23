package Recursion;

public class gfg {

    public static void main(String[] args) {
        int a = 7, b = 55;
        System.out.println(minimumMoves(a, b));
    }

    public static int minimumMoves(int A, int B) {

        int min = Math.min(A, B);
        int max = Math.max(A, B);


        if (max % min == 0) {
            return min;
        }

        else {
            return solve(min, max, 0);
        }
    }

    public static int solve(int a, int b, int cnt) {

        if (a == 1) {
            cnt += b;
            return cnt;
        }


        cnt += b / a;
        b = b % a;

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        return solve(min, max, cnt);
    }
}
