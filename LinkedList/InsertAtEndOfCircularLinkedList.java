package LinkedList;

import java.util.Random;

public class InsertAtEndOfCircularLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = head;

        Random rand = new Random();
        head = insertAtEndCLLOptimized(head, rand.nextInt(100));
        printCircularLinkedList(head);
    }

    static Node insertAtEndCLLOptimized(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
            return temp;
        }

        temp.next = head.next;
        head.next = temp;

        int val = head.data;
        head.data = temp.data;
        temp.data = val;

        return temp;
    }

    static void printCircularLinkedList(Node head) {
        if (head == null) return;

        Node curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

    }
}
