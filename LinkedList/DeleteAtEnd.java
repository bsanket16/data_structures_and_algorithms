package LinkedList;

import static LinkedList.InsertAtEnd.insertAtEnd;
import static LinkedList.TraversingLinkedList.printLinkedList;

public class DeleteAtEnd {
    public static void main(String[] args) {
        Node head = insertAtEnd(10, null);
        head = insertAtEnd(20, head);
        head = insertAtEnd(30, head);

        head = deleteAtEnd(head);
        printLinkedList(head);
    }

    static Node deleteAtEnd(Node head) {
        if (head == null || head.next == null) return null;

        Node curr = head;

        while (curr.next.next != null)
            curr = curr.next;

        curr.next = null;

        return head;
    }
}
