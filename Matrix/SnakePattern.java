package Matrix;

public class SnakePattern {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10}
        };

        for (int r=0; r<arr.length; r++) {
            if (r % 2 == 0) {
                for (int c=0; c<arr[r].length; c++) {
                    System.out.print(arr[r][c] + " ");
                }
            } else {
                for (int c=arr[r].length-1; c>=0; c--) {
                    System.out.print(arr[r][c] + " ");
                }
            }
            System.out.println();
        }
    }
}
