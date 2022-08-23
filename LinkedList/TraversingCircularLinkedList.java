package LinkedList;

public class TraversingCircularLinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = head;

        printCircularLinkedList(head);
    }

    static void printCircularLinkedList(Node head) {
        if (head == null) return;

        Node curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

//        System.out.print(head.data + " ");
//
//        for (Node p = head.next; p != head; p = p.next) {
//            System.out.print(p.data + " ");
//        }

    }
}
