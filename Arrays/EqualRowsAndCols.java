package Arrays;

import java.util.*;

public class EqualRowsAndCols {
    public static void main(String[] args) {
        int[][] num = {
                {3,2,1},
                {2,7,7},
                {2,7,7}
        };

        System.out.println(equalPairs(num));
    }
    public static int equalPairs(int[][] grid) {

        HashMap<int[], Integer> hs = new HashMap<>();

        hs.put(grid[0], hs.getOrDefault(grid[0], 0) + 1);
        hs.put(grid[1], hs.getOrDefault(grid[0], 0) + 1);
        hs.put(grid[2], hs.getOrDefault(grid[0], 0) + 1);

        System.out.println(Arrays.toString(grid[0]));
        System.out.println(Arrays.toString(grid[1]));
        System.out.println(Arrays.toString(grid[2]));

        int[] a = {1, 2, 4};
        int[] b = {1 ,2, 4};

        System.out.println(Arrays.equals(a, b));
        return hs.size();

    }
}
