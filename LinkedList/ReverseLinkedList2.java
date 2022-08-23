package LinkedList;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int left = 2, right = 3;

        printLinkedList(head);
        Node newHead = reverse(head, left, right);
        System.out.println();
        printLinkedList(newHead);
    }

    static Node reverse(Node head, int left, int right) {

        if (head == null || head.next == null) return head;
        if (left == right) return head;

        Node f = null, s = null;

        int cnt = 0;

        while (cnt < left - 1) {
            if (f == null) f = head;
            else f = f.next;
            cnt++;
        }

        cnt = 0;

        while (cnt < right) {
            if (s == null) s = head;
            else s = s.next;
            cnt++;
        }

        assert s != null;
        Node secondPartStart = s.next;
        s.next = null;

        Node firstPartStart = f != null ? f.next : head;


        if (f == null) {
            head = rev(head);
            firstPartStart.next = secondPartStart;
            return head;
        }

        f.next = rev(f.next);
        firstPartStart.next = secondPartStart;

        return head;
    }

    static Node rev(Node head) {

        Node prev = null, curr = head;

        while (curr != null) {
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
