package LinkedList;

import java.util.Random;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(35);
//        head.next.next.next.next.next = new Node(50);

        printLinkedList(head);
        middleOfLL(head);
        middleOfLLOptimized(head);
    }

    static void middleOfLLOptimized(Node head) {
        if (head == null) return;

        Node slow = head, fast = head;

        while (fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println(slow.data);
    }

    static void middleOfLL(Node head) {
        if (head == null) return;

        Node curr;
        int count = 0;

        for (curr = head; curr!=null; curr = curr.next) count++;

        curr = head;

        for (int i=0; i<count/2; i++) {
            curr = curr.next;
        }

        System.out.println();
        System.out.println(curr.data);
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
