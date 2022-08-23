package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {20, 30, 10, 5, 15};
        System.out.println(Arrays.toString(arr));
        getPreviousGreater(arr);
    }

    static void getPreviousGreater(int[] arr) {
        ArrayDeque<Integer> s = new ArrayDeque<>();

        s.push(arr[0]);
        System.out.print(-1 + " ");

        for (int i=1; i<arr.length; i++) {
            while(!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }

            System.out.print(s.isEmpty() ? -1 + " " : s.peek() + " ");
            s.push(arr[i]);
        }
    }
}
