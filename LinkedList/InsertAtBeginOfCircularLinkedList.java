package LinkedList;

import java.util.Random;

public class InsertAtBeginOfCircularLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = head;

        Random rand = new Random();
        head = insertAtBeginCLL(head, rand.nextInt(100));
        head = insertAtBeginCLLOptimized(head, rand.nextInt(100));
        printCircularLinkedList(head);
    }

    static Node insertAtBeginCLLOptimized(Node head, int x) {
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

        return head;
    }

    static Node insertAtBeginCLL(Node head, int x) {
        Node temp = new Node(x);
        if (head == null) {
            temp.next = temp;
        } else {
            Node curr = head;

            while (curr.next != head) {
                curr = curr.next;
            }

            temp.next = head;
            curr.next = temp;
        }

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
