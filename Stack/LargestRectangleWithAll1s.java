package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class LargestRectangleWithAll1s {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };

        System.out.println(getMaxRect(arr));
    }

    static int getMaxRect(int[][] arr) {
        int res = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; i>0 && j<arr[i].length; j++) {
                if (arr[i][j] != 0)
                    arr[i][j] += arr[i-1][j];
            }
            int curr = largestRectangularArea(arr[i]);
            res = Math.max(res, curr);
        }
        return res;
    }

    static int largestRectangularArea(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int res = 0;
        int top, curr;
        ArrayDeque<Integer> s = new ArrayDeque<>();

        for (int i=0; i<arr.length; i++) {
           while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
               top = s.peek(); s.pop();
               curr = arr[top] * ((s.isEmpty()) ? i : (i-s.peek()-1));
               res = Math.max(res, curr);
           }
           s.push(i);
        }
        while(!s.isEmpty()) {
            top = s.peek(); s.pop();
            curr = arr[top] * ((s.isEmpty()) ? arr.length : (arr.length-s.peek()-1));
            res = Math.max(res, curr);
        }
        return res;
    }


}
