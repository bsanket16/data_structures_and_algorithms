package LinkedList;

import java.util.HashSet;

public class RemoveDuplicatesInUnsortedArray {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);

        printLinkedList(head);
        System.out.println();
        printLinkedList(removeDups(head));
    }

    static Node removeDups(Node head) {
        HashSet<Integer> hs = new HashSet<>();

        Node curr = head;
        Node prev = head;

        hs.add(curr.data);

        while (curr.next != null) {
            if (hs.contains(curr.next.data)) {
                curr = curr.next;
                prev.next = null;
            } else {
                prev.next = curr.next;
                prev = curr.next;
                hs.add(curr.next.data);
                curr = curr.next;
            }
        }

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
