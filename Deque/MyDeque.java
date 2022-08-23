package Deque;

public class MyDeque {
    int sz, front, cap;
    int[] arr;

    MyDeque(int c) {
        sz = 0;
        front = 0;
        cap = c;
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
        return front;
    }

    int getRear() {
        if (isEmpty()) return -1;
        return (front+sz-1) % cap;
    }

    void insertRear(int d) {
        if (isFull()) return;
        int rear = getRear();
        rear = (rear+1) % cap;
        arr[rear] = d;
        sz++;
    }

    int deleteFront() {
        if (isEmpty()) return -1;
        int res = arr[getFront()];
        front = (front+1) % cap;
        sz--;
        return res;
    }

    void insertFront(int d) {
        if (isFull()) return;
        front = (front + sz) % cap;
        arr[front] = d;
        sz++;
    }

    int deleteRear() {
        if (isEmpty()) return -1;
        int res = arr[getRear()];
        sz--;
        return res;
    }
}

class test {
    public static void main(String[] args) {
        MyDeque dq = new MyDeque(5);

        System.out.println("Insert element at rear end  : 5 ");
        dq.insertRear(5);

        System.out.println("insert element at rear end : 10 ");
        dq.insertRear(10);

        System.out.println("get rear element : "+ dq.getRear());

        System.out.println(dq.deleteRear());
        System.out.println("After delete rear element new rear become : " +
                dq.getRear());

        System.out.println("inserting element at front end");
        dq.insertFront(15);
        dq.insertFront(5);

        System.out.println("get front element: " +dq.getFront());

        System.out.println(dq.deleteFront());

        System.out.println("After delete front element new front become : " + dq.getFront());
    }
}
