package LinkedList;

import static LinkedList.InsertAtEnd.insertAtEnd;
import static LinkedList.TraversingLinkedList.printLinkedList;

public class DeleteAtBegin {
    public static void main(String[] args) {
        Node head;
        head = insertAtEnd(10, null);
        head = insertAtEnd(20, head);
        head = insertAtEnd(30, head);

        head = deleteAtBegin(head);
        printLinkedList(head);
    }

    static Node deleteAtBegin(Node head) {
        if (head == null) return null;
        else return head.next;
    }
}
