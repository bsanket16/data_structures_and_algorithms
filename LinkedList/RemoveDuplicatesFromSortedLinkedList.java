package LinkedList;

public class RemoveDuplicatesFromSortedLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(30);

        printLinkedList(head);
        System.out.println();
        removeDuplicatesFromLinkedList(head);
        printLinkedList(head);
    }

    static Node removeDuplicates(Node head) {
        Node curr = head, prev = null;

        while (curr != null) {
            if (prev != null && curr.data == prev.data) {
                while (curr != null && curr.data == prev.data) {
                    curr = curr.next;
                }
                prev.next = curr;
            }
            prev = curr;
            if (curr!=null)curr = curr.next;
        }

        return head;
    }

    static void removeDuplicatesFromLinkedList(Node head) {
        Node curr = head;

        while (curr!=null && curr.next!=null) {
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
