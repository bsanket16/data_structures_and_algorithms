package LinkedList;

public class RecursiveLinkedListReverse {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(35);

        printLinkedList(head);
//        Node reversedHead = reverseLinkedListRecursive(head);
//        System.out.println();
//        printLinkedList(reversedHead);
        Node reversedAlHead = reverseLinkedListAlRecursive(head, null);
        System.out.println();
        printLinkedList(reversedAlHead);
    }

    static Node reverseLinkedListRecursive(Node head) {
        if (head == null || head.next == null) return head;
        Node rest_head = reverseLinkedListRecursive(head.next);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    static Node reverseLinkedListAlRecursive(Node curr, Node prev) {
        if (curr == null) return prev;

        Node next = curr.next;
        curr.next = prev;
        return reverseLinkedListAlRecursive(next, curr);
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
