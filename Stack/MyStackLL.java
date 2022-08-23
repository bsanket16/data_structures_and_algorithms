package Stack;

import java.util.ArrayDeque;
import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class MyStackLL {
    Node head;
    int sz;

    MyStackLL() {
        head = null;
        sz = 0;
    }

    void push(int d) {
        Node temp=new Node(d);
        temp.next=head;
        head=temp;
        System.out.println("pushed " + head.data);
        sz++;
    }

    void pop() {
        if (head == null) {
            System.out.println("nothing to pop");
            return;
        }
        System.out.println("popped " + head.data);
        head = head.next;
        sz--;
    }

    int size() {
        return sz;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void peek() {
        if (head == null) {
            System.out.println("stack empty");
            return;
        }

        System.out.println("peeked " + head.data);
    }

}

class StackLL {
    public static void main(String[] args) {
        MyStackLL s = new MyStackLL();

        s.peek();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(35);
        s.peek();
        s.pop();
        s.push(40);
        s.push(50);
        s.push(60);
        System.out.println("size " + s.size());
        System.out.println(s.isEmpty());
    }
}