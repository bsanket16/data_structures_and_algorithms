package LinkedList;

import java.util.Random;

public class InsertAtEndOfCircularDoublyLinkedList {
    public static void main(String[] args) {
        CDNode head=new CDNode(10);
        CDNode temp1=new CDNode(20);
        CDNode temp2=new CDNode(30);

        head.next=temp1;
        temp1.next=temp2;
        temp2.next=head;

        temp2.prev=temp1;
        temp1.prev=head;
        head.prev=temp2;

        Random rand = new Random();

        head=insertAtTail(head,rand.nextInt(100));
        printCircularDoublyLinkedList(head);
    }

    static CDNode insertAtTail(CDNode head, int x) {
        CDNode temp = new CDNode(x);
        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            return temp;
        }

        temp.prev = head.prev;
        temp.next = head;

        head.prev.next = temp;
        head.prev = temp;

        return head;
    }

    static void printCircularDoublyLinkedList(CDNode head) {
        if (head == null) return;

        CDNode curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

    }

}
