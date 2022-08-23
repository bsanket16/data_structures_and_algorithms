package Searching;

public class SquareRoot {
    public static void main(String[] args) {
        int x = 20;
        System.out.println(getSquareRoot(x));
    }

    static int getSquareRoot(int x) {
        int low = 1, high = x;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midSq = mid * mid;

            if (midSq == x) {
                return mid;
            }
            else if (midSq > x) {
                high = mid -1;
            }
            else {
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
