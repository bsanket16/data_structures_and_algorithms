package Queue;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class MyQueueLL {

    Node front, rear;
    int sz;

    MyQueueLL() {
        front = null;
        rear = null;
        sz = 0;
    }

    void getFront() {
        if (front!=null) {
            System.out.println(front.data);
        } else {
            System.out.println("queue is empty");
        }
    }

    void getRear() {
        if (rear!=null) {
            System.out.println(rear.data);
        } else {
            System.out.println("queue is empty");
        }
    }

    void enqueue(int x) {
        Node temp = new Node(x);
        System.out.println("added " + x);
        if (front == null) {
            rear = temp;
            front = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    void dequeue() {
        if (front==null) {
            System.out.println("queue is empty");
        } else {
            System.out.println("deleted " + front.data);
            front = front.next;
            sz--;
        }

        if (front==null) rear = null;
    }
 }

class TestQueues {
    public static void main(String[] args) {
        MyQueueLL q = new MyQueueLL();

        q.getFront();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.getFront();
        q.getRear();

        //queue is empty
        //added 1
        //added 2
        //deleted 1
        //added 3
        // added 4
        //added 5
        //2
        //5
    }
}
