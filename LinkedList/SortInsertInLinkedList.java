package LinkedList;

import java.util.Random;

public class SortInsertInLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        Random r = new Random();

        head = insertNode(head, r.nextInt(100));
        printLinkedList(head);
    }

    static Node insertNode(Node head, int x) {
        Node temp = new Node(x);

        if (head == null) return temp;
        else if (head.data > x) {
            temp.next = head;
            return temp;
        }

        Node curr = head;

        while (curr.next != null && curr.next.data < x) {
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;

        return head;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
