package LinkedList;

import java.util.Random;

public class DeleteAtBeginOfDoublyLinkedList {
    public static void main(String[] args) {
        DNode head = new DNode(10);

        Random rand = new Random();

        head = insertAtBeginDL(head, rand.nextInt(100));
        head = insertAtBeginDL(head, rand.nextInt(100));
        head = insertAtBeginDL(head, rand.nextInt(100));

        head = deleteAtBegin(head);

        printDoublyLinkedList(head);
    }

    static DNode deleteAtBegin(DNode head) {
        if (head == null || head.next == null) return null;
        else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }

    static void printDoublyLinkedList(DNode head) {
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
