package Matrix;

public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        System.out.println(search(arr, arr.length-1, 12));
    }

    static int search(int[][] arr, int r, int x) {
        int c = arr[r].length-1;

        int side = c, top = 0;

        while (side > -1 && top < r + 1) {
            if (arr[top][side] == x) return 1;
            else if (arr[top][side] > x) side--;
            else top++;
        }
        return -1;
    }
}
