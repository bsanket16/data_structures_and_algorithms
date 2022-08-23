package Queue;

public class MyQueue {
    int cap, sz, front;
    int[] arr;

    MyQueue(int c) {
        cap = c;
        sz = 0;
        front = 0;
        arr = new int[cap];
    }

    boolean isFull() {
        return sz == cap;
    }

    boolean isEmpty() {
        return sz == 0;
    }

    int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    int getBack() {
        if (isEmpty()) return -1;
        return arr[(front + sz - 1) % cap];
    }

    void enqueue(int x) {
        if (isFull()) return;
        int rear = getBack();
        rear = (rear+1) % cap;
        arr[rear] = x;
        sz++;
    }

    void dequeue() {
        if(isEmpty()) return;
        front = (front+1) % cap;
        sz--;
    }
}

class TestQueue {
    public static void main(String[] args) {
        MyQueue q = new MyQueue(5);

        System.out.println(q.getFront());
        System.out.println(q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        System.out.println(q.getFront());
        System.out.println(q.isFull());
        System.out.println(q.getBack());
    }
}
