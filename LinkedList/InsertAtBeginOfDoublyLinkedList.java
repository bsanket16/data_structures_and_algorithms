package LinkedList;

import java.util.Random;

public class InsertAtBeginOfDoublyLinkedList {
    public static void main(String[] args) {
        DNode head = new DNode(10);
        DNode temp = new DNode(20);

        head.next = temp;
        temp.prev = head;

        Random rand = new Random();

        head = insertAtBeginDL(head, rand.nextInt(100));

        printDoublyLinkedList(head);
    }

    private static void printDoublyLinkedList(DNode head) {
        DNode curr = head;

        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    static DNode insertAtBeginDL(DNode head, int x) {
        DNode temp = new DNode(x);

        if (head == null) return temp;

        temp.next = head;
        head.prev = temp;

        return temp;
    }
}
