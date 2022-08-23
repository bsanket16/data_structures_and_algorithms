package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbersRepresentedByLinkedLists {
    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(5);

        Node head2 = new Node(3);
        head2.next = new Node(4);
        head2.next.next = new Node(5);

        printLinkedList(head1);
        System.out.println();
        printLinkedList(head2);
        System.out.println();
        printLinkedList(addTwoLists(head1, head2));
    }

    static Node addTwoLists(Node first, Node second){
        int firstNum = 0, secondNum = 0;

        Node firstCurr = first, secondCurr = second;

        while (firstCurr!=null) {
            firstNum = (firstNum * 10) + firstCurr.data;
            firstCurr = firstCurr.next;
        }

        while (secondCurr!=null) {
            secondNum = (secondNum * 10) + secondCurr.data;
            secondCurr = secondCurr.next;
        }

        List<Integer> res = toList(firstNum + secondNum);

        Node op = new Node(0);
        Node curr = op;

        for (Integer re : res) {
            Node next = new Node(re);
            curr.next = next;
            curr = next;
        }

        return op.next;
    }

    static List<Integer> toList(int num) {
        String stringNumber = Integer.toString(num);
        List<Integer> result = new ArrayList<>(stringNumber.length());
        for(int i = 0; i < stringNumber.length(); i ++) {
            result.add(Integer.valueOf(stringNumber.substring(i, i + 1)));
        }
        return result;
    }

    static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}
