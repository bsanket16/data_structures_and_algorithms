package LinkedList;

public class TraversingLinkedList {
    public static void main(String[] args) {
            Node head = new Node(10);
            Node temp1 = new Node(20);
            Node temp2 = new Node(30);

            head.next = temp1;
            temp1.next = temp2;

            printLinkedList(head);
            System.out.println();
            printLinkedListRecursive(head);
    }

    static void printLinkedListRecursive(Node head) {
        if (head == null) return;
        System.out.print(head.data + " ");
        printLinkedListRecursive(head.next);
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
