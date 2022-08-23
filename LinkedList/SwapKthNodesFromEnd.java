package LinkedList;

public class SwapKthNodesFromEnd {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        printLinkedList(head);
        System.out.println();
        printLinkedList(swapKthNode(head, 4, 1));
    }

    static Node swapKthNode(Node head, int num, int k) {
        if (k > num) return head;

        Node one = head, two = head;

        for (int i=0; i<k-1; i++) {
            two = two.next;
        }

        Node firstPrevious = two;
        Node first = two.next;
        Node firstNext = two.next.next;

        while (two.next.next!=null) {
            one = one.next;
            two = two.next;
        }

        Node secondPrevious = one;
        Node second = one.next;
        Node secondNext = one.next.next;

        secondPrevious.next = first;
        first.next = secondNext;
        firstPrevious.next = second;
        second.next = firstPrevious;

        return second;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
