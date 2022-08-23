package LinkedList;

public class ReverseALinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(35);

        printLinkedList(head);
        Node reversedHead = reverseLinkedList(head);
        System.out.println();
        printLinkedList(reversedHead);
    }

    static Node reverseLinkedList(Node head) {
        Node curr = head, prev = null;
        while (curr!=null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
