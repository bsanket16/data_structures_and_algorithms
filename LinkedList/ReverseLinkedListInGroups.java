package LinkedList;

public class ReverseLinkedListInGroups {
    public static void main(String[] args) {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);
        head.next.next.next.next.next=new Node(60);
        head.next.next.next.next.next.next=new Node(70);
        printLinkedList(head);
        head=reverseIterative(head,3);
        head=reverseRecursive(head,3);
        System.out.println();
        printLinkedList(head);
    }

    static Node reverseRecursive(Node head, int k) {
        Node curr=head,next=null,prev=null;
        int count = 0;

        while (curr!=null && count<k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseRecursive(next, k);
        }

        return prev;
    }

    static Node reverseIterative(Node head, int k) {
        Node curr=head, prevFirst=null;
        boolean isFirstPass = true;

        while (curr!=null) {
            Node first = curr, prev = null;
            int count = 0;
            while (curr!=null && count<k) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }

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
