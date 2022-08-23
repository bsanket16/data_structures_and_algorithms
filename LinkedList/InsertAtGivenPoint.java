package LinkedList;

public class InsertAtGivenPoint {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);

        head = insertAtGivenPos(head, 2, 15);
        printLinkedList(head);
    }

    static Node insertAtGivenPos(Node head, int pos, int x) {
        Node temp = new Node(x);

        if (pos == 1) {
            temp.next = head;
            return temp;
        }

        Node curr = head;

        for (int i=1; i<=pos-2 && curr!=null; i++) {
            curr = curr.next;
        }

        if (curr == null) return head;

        temp.next = curr.next;
        curr.next = temp;

        return head;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
