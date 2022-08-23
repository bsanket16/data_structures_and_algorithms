package LinkedList;

public class SearchInALinkedList {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);

        head.next = temp1;
        temp1.next = temp2;

        int target = 40;

        System.out.println(searchLinkedList(head, target));
        System.out.println(searchLinkedListRecursive(head, target));
    }

    static int searchLinkedList(Node head, int target) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == target) return curr.data;
            curr = curr.next;
        }

        return -1;
    }

    static int searchLinkedListRecursive(Node head, int target) {
        if (head == null) return -1;
        if (head.data == target) return 1;
        else {
            int res = searchLinkedListRecursive(head.next, target);
            if (res == -1) return -1;
            else return res + 1;
        }
    }

}
