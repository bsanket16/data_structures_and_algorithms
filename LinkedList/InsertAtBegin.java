package LinkedList;

public class InsertAtBegin {
    public static void main(String[] args) {
        Node head = insertAtBegin(30, null);
        head = insertAtBegin(20, head);
        head = insertAtBegin(10, head);

        printLinkedList(head);
    }

    static Node insertAtBegin(int x, Node head) {
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
