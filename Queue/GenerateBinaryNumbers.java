package Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        int n = 6;
        generateBinaryNumbers(n);
    }

    static void generateBinaryNumbers(int n) {
        String curr = "1";

        Queue<String> q = new ArrayDeque<>();
        q.offer(curr);
        System.out.print(curr + " ");

        for (int i=1; i<n/2; i++) {
            String temp = q.poll();

            q.offer(temp + "0");
            System.out.print(temp + "0" + " ");

            q.offer(temp + "1");
            System.out.print(temp + "1" + " ");
        }

    }
}
