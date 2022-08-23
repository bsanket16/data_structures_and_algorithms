package LinkedList;

public class InsertAtEnd {
    public static void main(String[] args) {
        Node head = insertAtEnd(50, null);
        head = insertAtEnd(25, head);
        head = insertAtEnd(10, head);
        printLinkedList(head);
    }

    static Node insertAtEnd(int x, Node head) {
        Node temp = new Node(x);

        if (head == null) {
            return temp;
        }

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;

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
