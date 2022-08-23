package LinkedList;

public class PartitionLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(2);

        int x = 10;

        printLinkedList(partition(head, x));
    }
    public static Node partition(Node head, int x) {

        Node temp = new Node(0);
        Node newHead = null;
        Node retHead = null;

        Node curr = head;

        while (curr != null) {
            if (curr.data < x) {
                temp.next = new Node(curr.data);
                temp = temp.next;
                if (retHead == null) retHead = temp;
            }

            if (newHead == null && curr.data >= x) {
                newHead = curr;
            }

            curr = curr.next;
        }

        if (newHead == null) {
            return retHead;
        }

        curr = newHead.next;
        Node prev = newHead;

        while (curr != null) {

            if (curr.data >= x) {
                prev.next = curr;
                prev = curr;
            }

            curr = curr.next;
        }

        prev.next = null;

        temp.next = newHead;
        return retHead;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
