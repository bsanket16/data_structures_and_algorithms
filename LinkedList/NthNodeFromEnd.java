package LinkedList;

public class NthNodeFromEnd {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(35);

        int k = 3;

        printLinkedList(head);
        System.out.println();
        System.out.println(findNode(head, k));
        findNodeOptimized(head, k);
    }

    static int findNode(Node head, int k) {
        if (head == null || k == 0) return -1;
        int count = 0;
        Node curr = head;

        while(curr!=null) {
            curr = curr.next;
            count++;
        }

        if (count < k) return -1;

        count = count - k;
        curr = head;

        while (count > 0) {
            curr = curr.next;
            count--;
        }

        return curr.data;
    }

    static void findNodeOptimized(Node head, int k) {
        if (head == null) return;

        Node first = head;
        Node second = head;

        for (int i=0; i<k; i++) {
            if (first == null) return;
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println(second.data);
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}