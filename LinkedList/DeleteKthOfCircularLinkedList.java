package LinkedList;


public class DeleteKthOfCircularLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = head;

        head = deleteKthNode(head, 3);
        printCircularLinkedList(head);
    }

    static Node deleteKthNode(Node head, int k) {
        if (head == null) return null;

        if (k==1) return deleteAtBeginCLLOptimized(head);

        Node curr = head;

        for (int i=0; i<k-2; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }

    static Node deleteAtBeginCLLOptimized(Node head) {
        if (head == null || head.next == null) return null;

        head.data = head.next.data;
        head.next = head.next.next;

        return head;
    }

    static void printCircularLinkedList(Node head) {
        if (head == null) return;

        Node curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

    }
}
