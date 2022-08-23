package Queue;


import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);

        System.out.println(q);
        reverseQueue(q);
        System.out.println(q);
    }

    static void reverseQueue(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int x = q.poll();
        reverseQueue(q);
        q.offer(x);
    }
}
